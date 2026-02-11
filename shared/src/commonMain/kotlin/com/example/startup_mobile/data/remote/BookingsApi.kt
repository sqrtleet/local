package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.bookings.BookingCancelDto
import com.example.startup_mobile.data.dto.bookings.BookingListResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingStatsResponseDto
import com.example.startup_mobile.data.dto.bookings.BookingStatus
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.parameters

interface BookingsApi {
    suspend fun getMyBookings(
        page: Int? = null,
        perPage: Int? = null,
        status: BookingStatus? = null,
    ): PaginatedResponse<BookingListResponseDto>

    suspend fun getProviderBookings(
        page: Int? = null,
        perPage: Int? = null,
        status: BookingStatus? = null,
    ): PaginatedResponse<BookingListResponseDto>

    suspend fun getBookingStats(): BookingStatsResponseDto?
    suspend fun getBooking(id: Int): BookingResponseDto?
    suspend fun cancelBooking(id: Int, body: BookingCancelDto): BookingResponseDto?
    suspend fun completeBooking(id: Int): BookingResponseDto?
}

class DefaultBookingsApi(
    private val http: HttpClient,
) : BookingsApi {
    override suspend fun getMyBookings(
        page: Int?,
        perPage: Int?,
        status: BookingStatus?,
    ): PaginatedResponse<BookingListResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/bookings/my") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                        status?.let { append("_status", it.name.lowercase()) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun getProviderBookings(
        page: Int?,
        perPage: Int?,
        status: BookingStatus?,
    ): PaginatedResponse<BookingListResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/bookings/provider") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                        status?.let { append("_status", it.name.lowercase()) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun getBookingStats(): BookingStatsResponseDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/bookings/stats") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun getBooking(id: Int): BookingResponseDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/bookings/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun cancelBooking(id: Int, body: BookingCancelDto): BookingResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/bookings/$id/cancel") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun completeBooking(id: Int): BookingResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/bookings/$id/complete") {
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
