package com.example.startup_mobile.data.dto.tours

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class TourCategory {
    @SerialName("hiking")
    HIKING,
    @SerialName("cultural")
    CULTURAL,
    @SerialName("gastronomic")
    GASTRONOMIC,
    @SerialName("adventure")
    ADVENTURE,
    @SerialName("nature")
    NATURE,
    @SerialName("historical")
    HISTORICAL,
    @SerialName("photography")
    PHOTOGRAPHY,
    @SerialName("wellness")
    WELLNESS,
    @SerialName("other")
    OTHER,
}

@Serializable
enum class TourStatus {
    @SerialName("draft")
    DRAFT,
    @SerialName("published")
    PUBLISHED,
    @SerialName("archived")
    ARCHIVED,
}
