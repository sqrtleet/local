package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.remote.BookingsApi
import com.example.startup_mobile.domain.Booking
import com.example.startup_mobile.domain.Provider

class DefaultBookingsRepository(
    private val api: BookingsApi,
) : BookingsRepository {
    override suspend fun getBookings(): List<Booking> = api.getBookings().map { it.toDomain() }
    override suspend fun getBookingProvider(): List<Provider> = emptyList()
}
