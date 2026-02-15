package com.example.startup_mobile.data.mapping

import com.example.startup_mobile.data.dto.reviews.ProviderResponseCreateDto
import com.example.startup_mobile.data.dto.reviews.ReviewCreateDto
import com.example.startup_mobile.data.dto.reviews.ReviewListResponseDto
import com.example.startup_mobile.data.dto.reviews.ReviewResponseDto
import com.example.startup_mobile.data.dto.reviews.ReviewStatsResponseDto
import com.example.startup_mobile.data.dto.reviews.ReviewUpdateDto
import com.example.startup_mobile.domain.CreateReviewPayload
import com.example.startup_mobile.domain.ProviderResponsePayload
import com.example.startup_mobile.domain.Review
import com.example.startup_mobile.domain.ReviewStats
import com.example.startup_mobile.domain.UpdateReviewPayload

fun ReviewResponseDto.toDomain(): Review = Review(
    id = id,
    authorId = authorId,
    providerId = providerId,
    rating = rating,
    title = title,
    content = content,
    providerResponse = providerResponse,
    providerResponseAt = parseInstant(providerResponseAt),
    isVisible = isVisible,
    createdAt = parseInstant(createdAt),
    updatedAt = parseInstant(updatedAt),
    authorName = authorName,
    authorAvatar = authorAvatar,
    tourTitle = tourTitle,
)

fun ReviewListResponseDto.toDomain(): Review = Review(
    id = id,
    authorId = authorId,
    providerId = providerId,
    rating = rating,
    title = title,
    content = content,
    providerResponse = providerResponse,
    providerResponseAt = null,
    isVisible = true,
    createdAt = parseInstant(createdAt),
    updatedAt = null,
    authorName = authorName,
    authorAvatar = authorAvatar,
    tourTitle = null,
)

fun ReviewStatsResponseDto.toDomain(): ReviewStats = ReviewStats(
    averageRating = averageRating,
    totalReviews = totalReviews,
    ratingDistribution = ratingDistribution,
)

fun CreateReviewPayload.toDto(): ReviewCreateDto = ReviewCreateDto(
    rating = rating,
    title = title,
    content = content,
    providerId = providerId,
)

fun UpdateReviewPayload.toDto(): ReviewUpdateDto = ReviewUpdateDto(
    rating = rating,
    title = title,
    content = content,
)

fun ProviderResponsePayload.toDto(): ProviderResponseCreateDto = ProviderResponseCreateDto(response = response)
