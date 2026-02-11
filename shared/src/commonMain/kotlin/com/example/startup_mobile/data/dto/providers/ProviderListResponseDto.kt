package com.example.startup_mobile.data.dto.providers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProviderListResponseDto(
    @SerialName("id") val id: Int,
    @SerialName("user_id") val userId: Int,
    @SerialName("region") val region: String,
    @SerialName("city") val city: String? = null,
    @SerialName("specializations") val specializations: List<String>,
    @SerialName("bio") val bio: String? = null,
    @SerialName("experience_years") val experienceYears: Int,
    @SerialName("verification_status") val verificationStatus: VerificationStatus,
    @SerialName("user_name") val userName: String? = null,
    @SerialName("user_avatar") val userAvatar: String? = null,
    @SerialName("user_rating") val userRating: Double = 0.0,
)
