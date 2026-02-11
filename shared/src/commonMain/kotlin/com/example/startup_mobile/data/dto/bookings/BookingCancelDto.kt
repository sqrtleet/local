package com.example.startup_mobile.data.dto.bookings

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookingCancelDto(
    @SerialName("reason") val reason: String,
)
