package com.example.startup_mobile.data.dto.bookings

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingDto(
    @SerialName("id") val id: String,
    @SerialName("tour_id") val tourId: String,
    @SerialName("user_id") val userId: String,
    @SerialName("status") val status: String,
    @SerialName("created_at") val createdAt: String? = null,
)