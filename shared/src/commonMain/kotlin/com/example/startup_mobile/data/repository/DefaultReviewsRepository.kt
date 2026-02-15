package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.mapping.toDto
import com.example.startup_mobile.data.remote.ReviewsApi
import com.example.startup_mobile.domain.CreateReviewPayload
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.ProviderResponsePayload
import com.example.startup_mobile.domain.Review
import com.example.startup_mobile.domain.ReviewStats
import com.example.startup_mobile.domain.UpdateReviewPayload
import com.example.startup_mobile.domain.repository.ReviewsRepository

class DefaultReviewsRepository(
    private val api: ReviewsApi,
) : ReviewsRepository {
    override suspend fun getProviderReviewStats(providerId: Int): ReviewStats? =
        api.getProviderReviewStats(providerId)?.toDomain()

    override suspend fun getProviderReviews(
        page: Int?,
        perPage: Int?,
    ): Page<Review> {
        val response = api.getProviderReviews(page, perPage)
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun createReview(body: CreateReviewPayload): Review? =
        api.createReview(body.toDto())?.toDomain()

    override suspend fun getReview(id: Int): Review? = api.getReview(id)?.toDomain()

    override suspend fun updateReview(id: Int, body: UpdateReviewPayload): Review? =
        api.updateReview(id, body.toDto())?.toDomain()

    override suspend fun deleteReview(id: Int): com.example.startup_mobile.domain.MessageResult? =
        api.deleteReview(id)?.toDomain()

    override suspend fun respondToReview(id: Int, body: ProviderResponsePayload): Review? =
        api.respondToReview(id, body.toDto())?.toDomain()

    override suspend fun moderateReview(id: Int, isVisible: Boolean): Review? =
        api.moderateReview(id, isVisible)?.toDomain()
}
