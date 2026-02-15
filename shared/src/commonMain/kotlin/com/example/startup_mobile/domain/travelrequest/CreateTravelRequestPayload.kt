package com.example.startup_mobile.domain

import kotlinx.datetime.LocalDate

data class CreateTravelRequestPayload(
    val region: String,
    val city: String? = null,
    val title: String,
    val description: String,
    val categories: List<String> = emptyList(),
    val dateFrom: LocalDate,
    val dateTo: LocalDate,
    val flexibleDates: Boolean = false,
    val participantsCount: Int,
    val participantsInfo: String? = null,
    val budgetMin: String? = null,
    val budgetMax: String? = null,
    val currency: String = "RUB",
    val languages: List<String> = emptyList(),
    val specialRequirements: String? = null,
)
