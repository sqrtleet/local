package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.bookings.BookingDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

interface BookingsApi {
    suspend fun getBookings(): List<BookingDto>
}

class DefaultBookingsApi(
    private val http: HttpClient,
) : BookingsApi {
    override suspend fun getBookings(): List<BookingDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/bookings") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyList()
        }
    }
}
