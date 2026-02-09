package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TourDto(
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String = "",
    @SerialName("image_url") val imageUrl: String? = null,
    @SerialName("location") val location: String? = null,
    @SerialName("start_date") val startDate: String? = null,
    @SerialName("end_date") val endDate: String? = null,
)