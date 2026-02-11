package com.example.startup_mobile.data.dto.reviews

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewUpdateDto(
    @SerialName("rating") val rating: Int? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("content") val content: String? = null,
)
