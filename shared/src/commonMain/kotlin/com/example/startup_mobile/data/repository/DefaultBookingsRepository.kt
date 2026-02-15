package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.mapping.toDto
import com.example.startup_mobile.data.remote.BookingsApi
import com.example.startup_mobile.domain.Booking
import com.example.startup_mobile.domain.BookingStats
import com.example.startup_mobile.domain.CancelBookingPayload
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.repository.BookingsRepository

class DefaultBookingsRepository(
    private val api: BookingsApi,
) : BookingsRepository {
    override suspend fun getMyBookings(
        page: Int?,
        perPage: Int?,
        status: com.example.startup_mobile.domain.BookingStatus?,
    ): Page<Booking> {
        val response = api.getMyBookings(page, perPage, status?.toDto())
        return Page(
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
        status: com.example.startup_mobile.domain.BookingStatus?,
    ): Page<Booking> {
        val response = api.getProviderBookings(page, perPage, status?.toDto())
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun getBookingStats(): BookingStats? =
        api.getBookingStats()?.toDomain()

    override suspend fun getBooking(id: Int): Booking? = api.getBooking(id)?.toDomain()

    override suspend fun cancelBooking(id: Int, body: CancelBookingPayload): Booking? =
        api.cancelBooking(id, body.toDto())?.toDomain()

    override suspend fun completeBooking(id: Int): Booking? =
        api.completeBooking(id)?.toDomain()
}
