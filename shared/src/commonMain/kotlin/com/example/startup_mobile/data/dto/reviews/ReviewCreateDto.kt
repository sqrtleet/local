package com.example.startup_mobile.data.dto.reviews

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewCreateDto(
    @SerialName("rating") val rating: Int,
    @SerialName("title") val title: String? = null,
    @SerialName("content") val content: String? = null,
    @SerialName("provider_id") val providerId: Int,
)
