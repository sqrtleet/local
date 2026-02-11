package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TourRoutePointResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String? = null,
    @SerialName("coordinates") val coordinates: Map<String, Double>? = null,
    @SerialName("duration_minutes") val durationMinutes: Int? = null,
    @SerialName("order") val order: Int,
)
