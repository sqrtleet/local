package com.example.startup_mobile.data.dto.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    @SerialName("id") val id: Int,
    @SerialName("telegram_id") val telegramId: Int? = null,
    @SerialName("role") val role: UserRole,
    @SerialName("status") val status: UserStatus,
    @SerialName("name") val name: String,
    @SerialName("username") val username: String? = null,
    @SerialName("avatar_url") val avatarUrl: String? = null,
    @SerialName("phone") val phone: String? = null,
    @SerialName("email") val email: String? = null,
    @SerialName("rating") val rating: Double,
    @SerialName("reviews_count") val reviewsCount: Int,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
    @SerialName("is_provider") val isProvider: Boolean = false,
    @SerialName("provider_id") val providerId: Int? = null,
    @SerialName("verification_status") val verificationStatus: String? = null,
)