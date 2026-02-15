package com.example.startup_mobile.domain

import kotlinx.datetime.LocalDate

data class UpdateTravelRequestOfferPayload(
    val title: String? = null,
    val description: String? = null,
    val pricePerPerson: String? = null,
    val proposedDate: LocalDate? = null,
    val proposedTime: String? = null,
    val durationHours: Double? = null,
    val included: List<String>? = null,
    val notIncluded: List<String>? = null,
    val meetingPoint: String? = null,
    val providerMessage: String? = null,
)
