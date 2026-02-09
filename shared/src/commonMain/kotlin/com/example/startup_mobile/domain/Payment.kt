package com.example.startup_mobile.domain

data class Payment(
    val id: String,
    val status: PaymentStatus,
    val bookingId: String?,
    val createdAt: kotlinx.datetime.Instant?,
)

enum class PaymentStatus {
    PENDING,
    SUCCEEDED,
    FAILED,
    REFUNDED,
    CANCELLED,
}
