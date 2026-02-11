package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TourCreateDto(
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("short_description") val shortDescription: String? = null,
    @SerialName("category") val category: TourCategory = TourCategory.OTHER,
    @SerialName("price") val price: String,
    @SerialName("currency") val currency: String = "RUB",
    @SerialName("duration_hours") val durationHours: Double,
    @SerialName("max_participants") val maxParticipants: Int,
    @SerialName("min_participants") val minParticipants: Int = 1,
    @SerialName("region") val region: String,
    @SerialName("city") val city: String? = null,
    @SerialName("meeting_point") val meetingPoint: String? = null,
    @SerialName("coordinates") val coordinates: CoordinatesDto? = null,
    @SerialName("included") val included: List<String> = emptyList(),
    @SerialName("not_included") val notIncluded: List<String> = emptyList(),
    @SerialName("requirements") val requirements: String? = null,
    @SerialName("difficulty_level") val difficultyLevel: String? = null,
    @SerialName("languages") val languages: List<String> = listOf("Русский"),
    @SerialName("cancellation_policy") val cancellationPolicy: String? = null,
    @SerialName("images") val images: List<TourImageCreateDto> = emptyList(),
    @SerialName("route_points") val routePoints: List<TourRoutePointCreateDto> = emptyList(),
)
