package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProviderOfferResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("travel_request_id") val travelRequestId: Int,
    @SerialName("provider_id") val providerId: Int,
    @SerialName("tour_id") val tourId: Int? = null,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("price_per_person") val pricePerPerson: String,
    @SerialName("total_price") val totalPrice: String,
    @SerialName("currency") val currency: String,
    @SerialName("proposed_date") val proposedDate: String,
    @SerialName("proposed_time") val proposedTime: String? = null,
    @SerialName("duration_hours") val durationHours: Double,
    @SerialName("max_participants") val maxParticipants: Int,
    @SerialName("included") val included: List<String>,
    @SerialName("not_included") val notIncluded: List<String>,
    @SerialName("meeting_point") val meetingPoint: String? = null,
    @SerialName("status") val status: OfferStatus,
    @SerialName("provider_message") val providerMessage: String? = null,
    @SerialName("decline_reason") val declineReason: String? = null,
    @SerialName("expires_at") val expiresAt: String? = null,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("responded_at") val respondedAt: String? = null,
    @SerialName("booking_id") val bookingId: Int? = null,
    @SerialName("provider_name") val providerName: String? = null,
    @SerialName("provider_avatar") val providerAvatar: String? = null,
    @SerialName("provider_rating") val providerRating: Double? = null,
    @SerialName("provider_reviews_count") val providerReviewsCount: Int? = null,
    @SerialName("tour_title") val tourTitle: String? = null,
    @SerialName("tour_image") val tourImage: String? = null,
)
