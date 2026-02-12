package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.bookings.BookingCancelDto
import com.example.startup_mobile.data.dto.bookings.BookingStatus
import com.example.startup_mobile.data.dto.bookings.BookingStatsResponseDto
import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.remote.BookingsApi
import com.example.startup_mobile.domain.Booking

class DefaultBookingsRepository(
    private val api: BookingsApi,
) : BookingsRepository {
    override suspend fun getMyBookings(
        page: Int?,
        perPage: Int?,
        status: BookingStatus?,
    ): PaginatedResponse<Booking> {
        val response = api.getMyBookings(page, perPage, status)
        return PaginatedResponse(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun getProviderBookings(
        page: Int?,
        perPage: Int?,
        status: BookingStatus?,
    ): PaginatedResponse<Booking> {
        val response = api.getProviderBookings(page, perPage, status)
        return PaginatedResponse(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun getBookingStats(): BookingStatsResponseDto? = api.getBookingStats()

    override suspend fun getBooking(id: Int): Booking? = api.getBooking(id)?.toDomain()

    override suspend fun cancelBooking(id: Int, body: BookingCancelDto): Booking? =
        api.cancelBooking(id, body)?.toDomain()

    override suspend fun completeBooking(id: Int): Booking? =
        api.completeBooking(id)?.toDomain()
}
