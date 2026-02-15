package com.example.startup_mobile.domain

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

data class TravelRequestOffer(
    val id: Int,
    val travelRequestId: Int,
    val providerId: Int? = null,
    val tourId: Int? = null,
    val title: String? = null,
    val description: String? = null,
    val pricePerPerson: String? = null,
    val totalPrice: String? = null,
    val currency: String? = null,
    val proposedDate: LocalDate? = null,
    val proposedTime: String? = null,
    val durationHours: Double? = null,
    val maxParticipants: Int? = null,
    val included: List<String> = emptyList(),
    val notIncluded: List<String> = emptyList(),
    val meetingPoint: String? = null,
    val status: OfferStatus? = null,
    val providerMessage: String? = null,
    val declineReason: String? = null,
    val expiresAt: Instant? = null,
    val createdAt: Instant? = null,
    val updatedAt: Instant? = null,
    val respondedAt: Instant? = null,
    val bookingId: Int? = null,
    val providerName: String? = null,
    val providerAvatar: String? = null,
    val providerRating: Double? = null,
    val providerReviewsCount: Int? = null,
    val tourTitle: String? = null,
    val tourImage: String? = null,
)
