package com.example.startup_mobile.data.dto.bookings

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingStatsResponseDto(
    @SerialName("total_bookings") val totalBookings: Int = 0,
    @SerialName("pending_bookings") val pendingBookings: Int = 0,
    @SerialName("confirmed_bookings") val confirmedBookings: Int = 0,
    @SerialName("completed_bookings") val completedBookings: Int = 0,
    @SerialName("cancelled_bookings") val cancelledBookings: Int = 0,
    @SerialName("total_revenue") val totalRevenue: String = "0.00",
    @SerialName("total_payout") val totalPayout: String = "0.00",
)
