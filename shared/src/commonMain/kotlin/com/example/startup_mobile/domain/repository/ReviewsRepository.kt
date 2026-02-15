package com.example.startup_mobile.domain.repository

import com.example.startup_mobile.domain.CreateReviewPayload
import com.example.startup_mobile.domain.MessageResult
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.ProviderResponsePayload
import com.example.startup_mobile.domain.Review
import com.example.startup_mobile.domain.ReviewStats
import com.example.startup_mobile.domain.UpdateReviewPayload

interface ReviewsRepository {
    suspend fun getProviderReviewStats(providerId: Int): ReviewStats?
    suspend fun getProviderReviews(
        page: Int? = null,
        perPage: Int? = null,
    ): Page<Review>

    suspend fun createReview(body: CreateReviewPayload): Review?
    suspend fun getReview(id: Int): Review?
    suspend fun updateReview(id: Int, body: UpdateReviewPayload): Review?
    suspend fun deleteReview(id: Int): MessageResult?
    suspend fun respondToReview(id: Int, body: ProviderResponsePayload): Review?
    suspend fun moderateReview(id: Int, isVisible: Boolean): Review?
}
