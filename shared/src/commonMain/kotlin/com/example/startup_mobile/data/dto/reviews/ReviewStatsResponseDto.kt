package com.example.startup_mobile.data.dto.reviews

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewStatsResponseDto(
    @SerialName("average_rating") val averageRating: Double = 0.0,
    @SerialName("total_reviews") val totalReviews: Int = 0,
    @SerialName("rating_distribution") val ratingDistribution: Map<String, Int> = emptyMap(),
)
