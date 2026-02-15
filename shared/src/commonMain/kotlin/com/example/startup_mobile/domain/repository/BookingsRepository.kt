package com.example.startup_mobile.domain.repository

import com.example.startup_mobile.domain.Booking
import com.example.startup_mobile.domain.BookingStats
import com.example.startup_mobile.domain.BookingStatus
import com.example.startup_mobile.domain.CancelBookingPayload
import com.example.startup_mobile.domain.Page

interface BookingsRepository {
    suspend fun getMyBookings(
        page: Int? = null,
        perPage: Int? = null,
        status: BookingStatus? = null,
    ): Page<Booking>

    suspend fun getProviderBookings(
        page: Int? = null,
        perPage: Int? = null,
        status: BookingStatus? = null,
    ): Page<Booking>

    suspend fun getBookingStats(): BookingStats?
    suspend fun getBooking(id: Int): Booking?
    suspend fun cancelBooking(id: Int, body: CancelBookingPayload): Booking?
    suspend fun completeBooking(id: Int): Booking?
}
