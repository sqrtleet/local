package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TravelRequestCreateDto(
    @SerialName("region") val region: String,
    @SerialName("city") val city: String? = null,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("categories") val categories: List<String> = emptyList(),
    @SerialName("date_from") val dateFrom: String,
    @SerialName("date_to") val dateTo: String,
    @SerialName("flexible_dates") val flexibleDates: Boolean = false,
    @SerialName("participants_count") val participantsCount: Int,
    @SerialName("participants_info") val participantsInfo: String? = null,
    @SerialName("budget_min") val budgetMin: String? = null,
    @SerialName("budget_max") val budgetMax: String? = null,
    @SerialName("currency") val currency: String = "RUB",
    @SerialName("languages") val languages: List<String> = emptyList(),
    @SerialName("special_requirements") val specialRequirements: String? = null,
)
