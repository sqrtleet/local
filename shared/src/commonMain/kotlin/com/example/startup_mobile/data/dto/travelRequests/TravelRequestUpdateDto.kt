package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TravelRequestUpdateDto(
    @SerialName("region") val region: String? = null,
    @SerialName("city") val city: String? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("categories") val categories: List<String>? = null,
    @SerialName("date_from") val dateFrom: String? = null,
    @SerialName("date_to") val dateTo: String? = null,
    @SerialName("flexible_dates") val flexibleDates: Boolean? = null,
    @SerialName("participants_count") val participantsCount: Int? = null,
    @SerialName("participants_info") val participantsInfo: String? = null,
    @SerialName("budget_min") val budgetMin: String? = null,
    @SerialName("budget_max") val budgetMax: String? = null,
    @SerialName("languages") val languages: List<String>? = null,
    @SerialName("special_requirements") val specialRequirements: String? = null,
)
