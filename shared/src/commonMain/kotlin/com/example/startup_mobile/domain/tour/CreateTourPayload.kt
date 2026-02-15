package com.example.startup_mobile.domain

data class CoordinatesInput(
    val lat: Double,
    val lng: Double,
)

data class TourImageCreateInput(
    val url: String,
    val thumbnailUrl: String? = null,
    val altText: String? = null,
    val order: Int = 0,
    val isCover: Boolean = false,
)

data class TourRoutePointCreateInput(
    val title: String,
    val description: String? = null,
    val coordinates: CoordinatesInput? = null,
    val durationMinutes: Int? = null,
    val order: Int = 0,
)

data class CreateTourPayload(
    val title: String,
    val description: String,
    val shortDescription: String? = null,
    val category: TourCategory = TourCategory.OTHER,
    val price: String,
    val currency: String = "RUB",
    val durationHours: Double,
    val maxParticipants: Int,
    val minParticipants: Int = 1,
    val region: String,
    val city: String? = null,
    val meetingPoint: String? = null,
    val coordinates: CoordinatesInput? = null,
    val included: List<String> = emptyList(),
    val notIncluded: List<String> = emptyList(),
    val requirements: String? = null,
    val difficultyLevel: String? = null,
    val languages: List<String> = listOf("Русский"),
    val cancellationPolicy: String? = null,
    val images: List<TourImageCreateInput> = emptyList(),
    val routePoints: List<TourRoutePointCreateInput> = emptyList(),
)
