package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProviderOfferUpdateDto(
    @SerialName("title") val title: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("price_per_person") val pricePerPerson: String? = null,
    @SerialName("proposed_date") val proposedDate: String? = null,
    @SerialName("proposed_time") val proposedTime: String? = null,
    @SerialName("duration_hours") val durationHours: Double? = null,
    @SerialName("included") val included: List<String>? = null,
    @SerialName("not_included") val notIncluded: List<String>? = null,
    @SerialName("meeting_point") val meetingPoint: String? = null,
    @SerialName("provider_message") val providerMessage: String? = null,
)
