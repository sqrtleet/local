package com.example.startup_mobile.data.dto.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserStatusUpdateDto(
    @SerialName("status") val status: UserStatus,
    @SerialName("reason") val reason: String? = null,
)
