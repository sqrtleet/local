package com.example.startup_mobile.data.dto.reviews

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("author_id") val authorId: Int,
    @SerialName("provider_id") val providerId: Int,
    @SerialName("rating") val rating: Int,
    @SerialName("title") val title: String? = null,
    @SerialName("content") val content: String? = null,
    @SerialName("provider_response") val providerResponse: String? = null,
    @SerialName("provider_response_at") val providerResponseAt: String? = null,
    @SerialName("is_visible") val isVisible: Boolean,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("author_name") val authorName: String? = null,
    @SerialName("author_avatar") val authorAvatar: String? = null,
    @SerialName("tour_title") val tourTitle: String? = null,
)
