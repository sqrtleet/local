package com.example.startup_mobile.domain

import kotlinx.datetime.Instant

data class Provider(
    val id: Int,
    val userId: Int,
    val region: String,
    val city: String?,
    val specializations: List<String>,
    val bio: String?,
    val experienceYears: Int,
    val languages: List<String>,
    val verificationStatus: VerificationStatus,
    val verificationNote: String?,
    val verifiedAt: Instant?,
    val createdAt: Instant?,
    val updatedAt: Instant?,
    val userName: String?,
    val userAvatar: String?,
    val userRating: Double,
    val userReviewsCount: Int,
    val toursCount: Int,
    val completedBookings: Int,
)
