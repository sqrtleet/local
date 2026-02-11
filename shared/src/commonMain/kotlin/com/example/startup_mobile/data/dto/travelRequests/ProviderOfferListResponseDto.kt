package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProviderOfferListResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("travel_request_id") val travelRequestId: Int,
    @SerialName("title") val title: String,
    @SerialName("price_per_person") val pricePerPerson: String,
    @SerialName("total_price") val totalPrice: String,
    @SerialName("currency") val currency: String,
    @SerialName("proposed_date") val proposedDate: String,
    @SerialName("duration_hours") val durationHours: Double,
    @SerialName("status") val status: OfferStatus,
    @SerialName("created_at") val createdAt: String,
    @SerialName("provider_name") val providerName: String? = null,
    @SerialName("provider_avatar") val providerAvatar: String? = null,
)
