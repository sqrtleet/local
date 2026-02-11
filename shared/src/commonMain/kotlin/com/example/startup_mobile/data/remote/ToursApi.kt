package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.common.MessageResponseDto
import com.example.startup_mobile.data.dto.tours.TourCreateDto
import com.example.startup_mobile.data.dto.tours.TourListResponseDto
import com.example.startup_mobile.data.dto.tours.TourResponseDto
import com.example.startup_mobile.data.dto.tours.TourUpdateDto
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.parameters

interface ToursApi {
    suspend fun getMyTours(page: Int? = null, perPage: Int? = null): PaginatedResponse<TourListResponseDto>
    suspend fun createTour(body: TourCreateDto): TourResponseDto?
    suspend fun getTour(id: Int): TourResponseDto?
    suspend fun updateTour(id: Int, body: TourUpdateDto): TourResponseDto?
    suspend fun publishTour(id: Int): TourResponseDto?
    suspend fun archiveTour(id: Int): TourResponseDto?
    suspend fun addTourImage(
        id: Int,
        fileBytes: ByteArray,
        fileName: String,
        isCover: Boolean? = null,
    ): TourResponseDto?

    suspend fun deleteTourImage(tourId: Int, imageId: Int): MessageResponseDto?
}

class DefaultToursApi(
    private val http: HttpClient,
) : ToursApi {
    override suspend fun getMyTours(page: Int?, perPage: Int?): PaginatedResponse<TourListResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/tours/my") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun createTour(body: TourCreateDto): TourResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/tours") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.Created -> response.body()
            else -> null
        }
    }

    override suspend fun getTour(id: Int): TourResponseDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/tours/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateTour(id: Int, body: TourUpdateDto): TourResponseDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/tours/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun publishTour(id: Int): TourResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/tours/$id/publish") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun archiveTour(id: Int): TourResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/tours/$id/archive") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun addTourImage(
        id: Int,
        fileBytes: ByteArray,
        fileName: String,
        isCover: Boolean?,
    ): TourResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/tours/$id/images") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        isCover?.let { append("is_cover", it.toString()) }
                    }
                )
            }
            setBody(
                MultiPartFormDataContent(
                    formData {
                        append(
                            "file",
                            fileBytes,
                            Headers.build {
                                append(
                                    HttpHeaders.ContentDisposition,
                                    "form-data; name=\"file\"; filename=\"$fileName\""
                                )
                            }
                        )
                    }
                )
            )
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun deleteTourImage(tourId: Int, imageId: Int): MessageResponseDto? {
        val response: HttpResponse = http.client.delete("${http.baseUrl}/tours/$tourId/images/$imageId") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    private fun <T> emptyPaginatedResponse(
        page: Int?,
        perPage: Int?,
    ): PaginatedResponse<T> = PaginatedResponse(
        items = emptyList(),
        total = 0,
        page = page ?: 1,
        perPage = perPage ?: 0,
        pages = 0,
    )
}
