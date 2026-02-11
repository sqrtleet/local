package com.example.startup_mobile.data.dto.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class UserRole {
    @SerialName("traveler")
    TRAVELER,
    @SerialName("provider")
    PROVIDER,
    @SerialName("admin")
    ADMIN,
}

@Serializable
enum class UserStatus {
    @SerialName("active")
    ACTIVE,
    @SerialName("blocked")
    BLOCKED,
    @SerialName("pending")
    PENDING,
}
