package com.example.startup_mobile.data.dto.providers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProviderDto(
    @SerialName("id") val id: Int,
    @SerialName("user_id") val userId: Int,
    @SerialName("region") val region: String,
    @SerialName("city") val city: String,
    @SerialName("specializations") val specializations: List<String>,
    @SerialName("bio") val bio: String,
    @SerialName("experience_years") val experienceYears: Int,
    @SerialName("languages") val languages: List<String>,
    @SerialName("verification_status") val verificationStatus: String,
    @SerialName("verification_note") val verificationNote: String,
    @SerialName("verified_at") val verifiedAt: String? = null,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("user_name") val userName: String,
    @SerialName("user_avatar") val userAvatar: String? = null,
    @SerialName("user_rating") val userRating: Double = 0.0,
    @SerialName("user_reviews_count") val userReviewsCount: Int = 0,
    @SerialName("tours_count") val toursCount: Int = 0,
    @SerialName("completed_bookings") val completedBookings: Int = 0,
)