package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TravelRequestResponse(
    @SerialName("id") val id: Int,
    @SerialName("user_id") val userId: Int,
    @SerialName("region") val region: String,
    @SerialName("city") val city: String? = null,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("categories") val categories: List<String>,
    @SerialName("date_from") val dateFrom: String,
    @SerialName("date_to") val dateTo: String,
    @SerialName("flexible_dates") val flexibleDates: Boolean,
    @SerialName("participants_count") val participantsCount: Int,
    @SerialName("participants_info") val participantsInfo: String? = null,
    @SerialName("budget_min") val budgetMin: String? = null,
    @SerialName("budget_max") val budgetMax: String? = null,
    @SerialName("currency") val currency: String,
    @SerialName("status") val status: RequestStatus,
    @SerialName("languages") val languages: List<String>,
    @SerialName("special_requirements") val specialRequirements: String? = null,
    @SerialName("expires_at") val expiresAt: String? = null,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("offers_count") val offersCount: Int = 0,
    @SerialName("user_name") val userName: String? = null,
    @SerialName("user_avatar") val userAvatar: String? = null,
)
