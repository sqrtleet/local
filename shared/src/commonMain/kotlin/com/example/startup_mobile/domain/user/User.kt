package com.example.startup_mobile.domain

import kotlinx.datetime.Instant

data class User(
    val id: Int,
    val telegramId: Int?,
    val role: UserRole,
    val status: UserStatus,
    val name: String,
    val username: String?,
    val avatarUrl: String?,
    val phone: String?,
    val email: String?,
    val rating: Double,
    val reviewsCount: Int,
    val createdAt: Instant?,
    val updatedAt: Instant?,
    val isProvider: Boolean,
    val providerId: Int?,
    val verificationStatus: String?,
)
