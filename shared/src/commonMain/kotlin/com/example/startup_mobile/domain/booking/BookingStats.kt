package com.example.startup_mobile.domain

data class BookingStats(
    val totalBookings: Int = 0,
    val pendingBookings: Int = 0,
    val confirmedBookings: Int = 0,
    val completedBookings: Int = 0,
    val cancelledBookings: Int = 0,
    val totalRevenue: String = "0.00",
    val totalPayout: String = "0.00",
)
