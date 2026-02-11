package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TourImageCreateDto(
    @SerialName("url") val url: String,
    @SerialName("thumbnail_url") val thumbnailUrl: String? = null,
    @SerialName("alt_text") val altText: String? = null,
    @SerialName("order") val order: Int = 0,
    @SerialName("is_cover") val isCover: Boolean = false,
)
