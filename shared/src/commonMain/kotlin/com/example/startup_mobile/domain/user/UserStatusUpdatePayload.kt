package com.example.startup_mobile.domain

data class UserStatusUpdatePayload(
    val status: UserStatus,
    val reason: String? = null,
)
