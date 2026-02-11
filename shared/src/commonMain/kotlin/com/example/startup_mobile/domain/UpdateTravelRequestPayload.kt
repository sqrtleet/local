package com.example.startup_mobile.domain

import kotlinx.datetime.LocalDate

data class UpdateTravelRequestPayload(
    val region: String? = null,
    val city: String? = null,
    val title: String? = null,
    val description: String? = null,
    val categories: List<String>? = null,
    val dateFrom: LocalDate? = null,
    val dateTo: LocalDate? = null,
    val flexibleDates: Boolean? = null,
    val participantsCount: Int? = null,
    val participantsInfo: String? = null,
    val budgetMin: String? = null,
    val budgetMax: String? = null,
    val languages: List<String>? = null,
    val specialRequirements: String? = null,
)
