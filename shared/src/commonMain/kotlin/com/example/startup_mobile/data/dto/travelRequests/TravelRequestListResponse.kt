package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TravelRequestListResponse(
    @SerialName("id") val id: Int,
    @SerialName("region") val region: String,
    @SerialName("city") val city: String? = null,
    @SerialName("title") val title: String,
    @SerialName("date_from") val dateFrom: String,
    @SerialName("date_to") val dateTo: String,
    @SerialName("participants_count") val participantsCount: Int,
    @SerialName("budget_min") val budgetMin: String? = null,
    @SerialName("budget_max") val budgetMax: String? = null,
    @SerialName("currency") val currency: String,
    @SerialName("status") val status: RequestStatus,
    @SerialName("categories") val categories: List<String>,
    @SerialName("offers_count") val offersCount: Int = 0,
    @SerialName("created_at") val createdAt: String,
    @SerialName("user_name") val userName: String? = null,
)
