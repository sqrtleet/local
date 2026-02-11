package com.example.startup_mobile.domain

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate

data class TravelRequest(
    val id: Int,
    val userId: Int? = null,
    val region: String? = null,
    val city: String? = null,
    val title: String? = null,
    val description: String? = null,
    val categories: List<String> = emptyList(),
    val dateFrom: LocalDate? = null,
    val dateTo: LocalDate? = null,
    val flexibleDates: Boolean? = null,
    val participantsCount: Int? = null,
    val participantsInfo: String? = null,
    val budgetMin: String? = null,
    val budgetMax: String? = null,
    val currency: String? = null,
    val status: RequestStatus? = null,
    val languages: List<String> = emptyList(),
    val specialRequirements: String? = null,
    val expiresAt: Instant? = null,
    val createdAt: Instant? = null,
    val updatedAt: Instant? = null,
    val offersCount: Int? = null,
    val userName: String? = null,
    val userAvatar: String? = null,
)
