package com.example.startup_mobile.domain

import kotlinx.datetime.Instant

data class Review(
    val id: Int,
    val authorId: Int,
    val providerId: Int,
    val rating: Int,
    val title: String? = null,
    val content: String? = null,
    val providerResponse: String? = null,
    val providerResponseAt: Instant? = null,
    val isVisible: Boolean = true,
    val createdAt: Instant? = null,
    val updatedAt: Instant? = null,
    val authorName: String? = null,
    val authorAvatar: String? = null,
    val tourTitle: String? = null,
)

data class ReviewStats(
    val averageRating: Double = 0.0,
    val totalReviews: Int = 0,
    val ratingDistribution: Map<String, Int> = emptyMap(),
)

data class CreateReviewPayload(
    val rating: Int,
    val title: String? = null,
    val content: String? = null,
    val providerId: Int,
)

data class UpdateReviewPayload(
    val rating: Int? = null,
    val title: String? = null,
    val content: String? = null,
)

data class ProviderResponsePayload(
    val response: String,
)
