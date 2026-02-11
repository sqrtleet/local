package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TourImageResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("url") val url: String,
    @SerialName("thumbnail_url") val thumbnailUrl: String? = null,
    @SerialName("alt_text") val altText: String? = null,
    @SerialName("order") val order: Int,
    @SerialName("is_cover") val isCover: Boolean,
)
