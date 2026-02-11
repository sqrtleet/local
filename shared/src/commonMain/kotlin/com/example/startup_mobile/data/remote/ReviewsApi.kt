package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.common.MessageResponseDto
import com.example.startup_mobile.data.dto.reviews.ProviderResponseCreateDto
import com.example.startup_mobile.data.dto.reviews.ReviewCreateDto
import com.example.startup_mobile.data.dto.reviews.ReviewListResponseDto
import com.example.startup_mobile.data.dto.reviews.ReviewResponseDto
import com.example.startup_mobile.data.dto.reviews.ReviewStatsResponseDto
import com.example.startup_mobile.data.dto.reviews.ReviewUpdateDto
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.parameters

interface ReviewsApi {
    suspend fun getProviderReviewStats(providerId: Int): ReviewStatsResponseDto?
    suspend fun getProviderReviews(
        page: Int? = null,
        perPage: Int? = null,
    ): PaginatedResponse<ReviewListResponseDto>

    suspend fun createReview(body: ReviewCreateDto): ReviewResponseDto?
    suspend fun getReview(id: Int): ReviewResponseDto?
    suspend fun updateReview(id: Int, body: ReviewUpdateDto): ReviewResponseDto?
    suspend fun deleteReview(id: Int): MessageResponseDto?
    suspend fun respondToReview(id: Int, body: ProviderResponseCreateDto): ReviewResponseDto?
    suspend fun moderateReview(id: Int, isVisible: Boolean): ReviewResponseDto?
}

class DefaultReviewsApi(
    private val http: HttpClient,
) : ReviewsApi {
    override suspend fun getProviderReviewStats(providerId: Int): ReviewStatsResponseDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/reviews/provider/stats") {
            url {
                parameters.appendAll(
                    parameters {
                        append("provider_id", providerId.toString())
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun getProviderReviews(
        page: Int?,
        perPage: Int?,
    ): PaginatedResponse<ReviewListResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/reviews/provider") {
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

    override suspend fun createReview(body: ReviewCreateDto): ReviewResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/reviews") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.Created -> response.body()
            else -> null
        }
    }

    override suspend fun getReview(id: Int): ReviewResponseDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/reviews/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateReview(id: Int, body: ReviewUpdateDto): ReviewResponseDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/reviews/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun deleteReview(id: Int): MessageResponseDto? {
        val response: HttpResponse = http.client.delete("${http.baseUrl}/reviews/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun respondToReview(id: Int, body: ProviderResponseCreateDto): ReviewResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/reviews/$id/respond") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun moderateReview(id: Int, isVisible: Boolean): ReviewResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/reviews/$id/moderate") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        append("is_visible", isVisible.toString())
                    }
                )
            }
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
