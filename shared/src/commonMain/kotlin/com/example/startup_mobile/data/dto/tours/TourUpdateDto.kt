package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TourUpdateDto(
    @SerialName("title") val title: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("short_description") val shortDescription: String? = null,
    @SerialName("category") val category: TourCategory? = null,
    @SerialName("price") val price: String? = null,
    @SerialName("currency") val currency: String? = null,
    @SerialName("duration_hours") val durationHours: Double? = null,
    @SerialName("max_participants") val maxParticipants: Int? = null,
    @SerialName("min_participants") val minParticipants: Int? = null,
    @SerialName("region") val region: String? = null,
    @SerialName("city") val city: String? = null,
    @SerialName("meeting_point") val meetingPoint: String? = null,
    @SerialName("coordinates") val coordinates: CoordinatesDto? = null,
    @SerialName("included") val included: List<String>? = null,
    @SerialName("not_included") val notIncluded: List<String>? = null,
    @SerialName("requirements") val requirements: String? = null,
    @SerialName("difficulty_level") val difficultyLevel: String? = null,
    @SerialName("languages") val languages: List<String>? = null,
    @SerialName("cancellation_policy") val cancellationPolicy: String? = null,
    @SerialName("status") val status: TourStatus? = null,
)
