package com.example.startup_mobile.domain

data class UpdateTourPayload(
    val title: String? = null,
    val description: String? = null,
    val shortDescription: String? = null,
    val category: TourCategory? = null,
    val price: String? = null,
    val currency: String? = null,
    val durationHours: Double? = null,
    val maxParticipants: Int? = null,
    val minParticipants: Int? = null,
    val region: String? = null,
    val city: String? = null,
    val meetingPoint: String? = null,
    val coordinates: CoordinatesInput? = null,
    val included: List<String>? = null,
    val notIncluded: List<String>? = null,
    val requirements: String? = null,
    val difficultyLevel: String? = null,
    val languages: List<String>? = null,
    val cancellationPolicy: String? = null,
    val status: TourStatus? = null,
)
