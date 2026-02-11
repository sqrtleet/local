package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TourResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("provider_id") val providerId: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("short_description") val shortDescription: String? = null,
    @SerialName("category") val category: TourCategory,
    @SerialName("price") val price: String,
    @SerialName("currency") val currency: String,
    @SerialName("duration_hours") val durationHours: Double,
    @SerialName("max_participants") val maxParticipants: Int,
    @SerialName("min_participants") val minParticipants: Int,
    @SerialName("region") val region: String,
    @SerialName("city") val city: String? = null,
    @SerialName("meeting_point") val meetingPoint: String? = null,
    @SerialName("coordinates") val coordinates: Map<Double, Double>? = null,
    @SerialName("status") val status: TourStatus,
    @SerialName("rating") val rating: Double,
    @SerialName("reviews_count") val reviewsCount: Int,
    @SerialName("bookings_count") val bookingsCount: Int,
    @SerialName("views_count") val viewsCount: Int,
    @SerialName("included") val included: List<String>,
    @SerialName("not_included") val notIncluded: List<String>,
    @SerialName("requirements") val requirements: String? = null,
    @SerialName("difficulty_level") val difficultyLevel: String? = null,
    @SerialName("languages") val languages: List<String>,
    @SerialName("cancellation_policy") val cancellationPolicy: String? = null,
    @SerialName("images") val images: List<TourImageResponseDto> = emptyList(),
    @SerialName("route_points") val routePoints: List<TourRoutePointResponseDto> = emptyList(),
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("published_at") val publishedAt: String? = null,
    @SerialName("provider_name") val providerName: String? = null,
    @SerialName("provider_avatar") val providerAvatar: String? = null,
    @SerialName("provider_rating") val providerRating: Double = 0.0,
    @SerialName("provider_verified") val providerVerified: Boolean = false,
)
