package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.bookings.BookingCancelDto
import com.example.startup_mobile.data.dto.bookings.BookingStatus
import com.example.startup_mobile.domain.Booking

interface BookingsRepository {
    suspend fun getMyBookings(
        page: Int? = null,
        perPage: Int? = null,
        status: BookingStatus? = null,
    ): PaginatedResponse<Booking>

    suspend fun getProviderBookings(
        page: Int? = null,
        perPage: Int? = null,
        status: BookingStatus? = null,
    ): PaginatedResponse<Booking>

    suspend fun getBookingStats(): com.example.startup_mobile.data.dto.bookings.BookingStatsResponseDto?
    suspend fun getBooking(id: Int): Booking?
    suspend fun cancelBooking(id: Int, body: BookingCancelDto): Booking?
    suspend fun completeBooking(id: Int): Booking?
}
