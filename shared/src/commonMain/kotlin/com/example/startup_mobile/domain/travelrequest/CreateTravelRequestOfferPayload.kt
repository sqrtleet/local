package com.example.startup_mobile.domain

import kotlinx.datetime.LocalDate

data class CreateTravelRequestOfferPayload(
    val title: String,
    val description: String,
    val travelRequestId: Int,
    val tourId: Int? = null,
    val pricePerPerson: String,
    val currency: String = "RUB",
    val proposedDate: LocalDate,
    val proposedTime: String? = null,
    val durationHours: Double,
    val maxParticipants: Int,
    val included: List<String> = emptyList(),
    val notIncluded: List<String> = emptyList(),
    val meetingPoint: String? = null,
    val providerMessage: String? = null,
)
