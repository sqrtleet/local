package com.example.startup_mobile.data.dto.bookings

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BookingStatus {
    @SerialName("pending")
    PENDING,
    @SerialName("confirmed")
    CONFIRMED,
    @SerialName("cancelled")
    CANCELLED,
    @SerialName("completed")
    COMPLETED,
    @SerialName("expired")
    EXPIRED,
}

@Serializable
enum class PaymentStatus {
    @SerialName("pending")
    PENDING,
    @SerialName("paid")
    PAID,
    @SerialName("refunded")
    REFUNDED,
    @SerialName("failed")
    FAILED,
}
