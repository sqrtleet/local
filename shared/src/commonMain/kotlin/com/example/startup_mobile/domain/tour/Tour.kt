package com.example.startup_mobile.domain

data class Tour(
    val id: Int,
    val providerId: Int? = null,
    val title: String,
    val description: String? = null,
    val shortDescription: String? = null,
    val category: TourCategory? = null,
    val price: String? = null,
    val currency: String? = null,
    val durationHours: Double? = null,
    val maxParticipants: Int? = null,
    val minParticipants: Int? = null,
    val region: String? = null,
    val city: String? = null,
    val meetingPoint: String? = null,
    val coordinates: Map<Double, Double>? = null,
    val status: TourStatus? = null,
    val rating: Double? = null,
    val reviewsCount: Int? = null,
    val bookingsCount: Int? = null,
    val viewsCount: Int? = null,
    val included: List<String> = emptyList(),
    val notIncluded: List<String> = emptyList(),
    val requirements: String? = null,
    val difficultyLevel: String? = null,
    val languages: List<String> = emptyList(),
    val cancellationPolicy: String? = null,
    val coverImage: String? = null,
    val images: List<TourImage> = emptyList(),
    val routePoints: List<TourRoutePoint> = emptyList(),
    val createdAt: kotlinx.datetime.Instant? = null,
    val updatedAt: kotlinx.datetime.Instant? = null,
    val publishedAt: kotlinx.datetime.Instant? = null,
    val providerName: String? = null,
    val providerAvatar: String? = null,
    val providerRating: Double? = null,
    val providerVerified: Boolean? = null,
)

data class TourImage(
    val id: Int,
    val url: String,
    val thumbnailUrl: String?,
    val altText: String?,
    val order: Int,
    val isCover: Boolean,
)

data class TourRoutePoint(
    val id: Int,
    val title: String,
    val description: String?,
    val coordinates: Map<String, Double>?,
    val durationMinutes: Int?,
    val order: Int,
)

enum class TourCategory {
    HIKING,
    CULTURAL,
    GASTRONOMIC,
    ADVENTURE,
    NATURE,
    HISTORICAL,
    PHOTOGRAPHY,
    WELLNESS,
    OTHER,
}

enum class TourStatus {
    DRAFT,
    PUBLISHED,
    ARCHIVED,
}
