package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProviderOfferCreateDto(
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("travel_request_id") val travelRequestId: Int,
    @SerialName("tour_id") val tourId: Int? = null,
    @SerialName("price_per_person") val pricePerPerson: String,
    @SerialName("currency") val currency: String = "RUB",
    @SerialName("proposed_date") val proposedDate: String,
    @SerialName("proposed_time") val proposedTime: String? = null,
    @SerialName("duration_hours") val durationHours: Double,
    @SerialName("max_participants") val maxParticipants: Int,
    @SerialName("included") val included: List<String> = emptyList(),
    @SerialName("not_included") val notIncluded: List<String> = emptyList(),
    @SerialName("meeting_point") val meetingPoint: String? = null,
    @SerialName("provider_message") val providerMessage: String? = null,
)
