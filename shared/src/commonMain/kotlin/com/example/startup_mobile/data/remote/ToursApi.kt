package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.tours.TourDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

interface ToursApi {
    suspend fun getTours(): List<TourDto>
    suspend fun getTour(id: String): TourDto?
}

class DefaultToursApi(
    private val http: HttpClient,
) : ToursApi {
    override suspend fun getTours(): List<TourDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/tours") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyList()
        }
    }

    override suspend fun getTour(id: String): TourDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/tours/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }
}
