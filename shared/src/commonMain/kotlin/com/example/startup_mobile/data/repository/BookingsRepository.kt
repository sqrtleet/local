package com.example.startup_mobile.data.repository

import com.example.startup_mobile.domain.Booking
import com.example.startup_mobile.domain.Provider

interface BookingsRepository {
    suspend fun getBookings(): List<Booking>
    suspend fun getBookingProvider(): List<Provider>
}
