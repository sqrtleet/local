package com.example.startup_mobile.domain

data class Tour(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String?,
    val location: String?,
    val startDate: kotlinx.datetime.Instant?,
    val endDate: kotlinx.datetime.Instant?,
)
