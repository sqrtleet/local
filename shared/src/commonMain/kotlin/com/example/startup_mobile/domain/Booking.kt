package com.example.startup_mobile.domain

data class Booking(
    val id: String,
    val tourId: String,
    val userId: String,
    val status: BookingStatus,
    val createdAt: kotlinx.datetime.Instant?,
)

enum class BookingStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    COMPLETED,
}
