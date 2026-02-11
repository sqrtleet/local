package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TourListResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("provider_id") val providerId: Int,
    @SerialName("title") val title: String,
    @SerialName("short_description") val shortDescription: String? = null,
    @SerialName("category") val category: TourCategory,
    @SerialName("price") val price: String,
    @SerialName("currency") val currency: String,
    @SerialName("duration_hours") val durationHours: Double,
    @SerialName("max_participants") val maxParticipants: Int,
    @SerialName("region") val region: String,
    @SerialName("city") val city: String? = null,
    @SerialName("status") val status: TourStatus,
    @SerialName("rating") val rating: Double,
    @SerialName("reviews_count") val reviewsCount: Int,
    @SerialName("cover_image") val coverImage: String? = null,
    @SerialName("provider_name") val providerName: String? = null,
    @SerialName("provider_rating") val providerRating: Double = 0.0,
    @SerialName("provider_verified") val providerVerified: Boolean = false,
)
