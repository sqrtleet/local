package com.example.startup_mobile.data.dto.travelRequests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RequestStatus {
    @SerialName("active")
    ACTIVE,
    @SerialName("in_progress")
    IN_PROGRESS,
    @SerialName("completed")
    COMPLETED,
    @SerialName("cancelled")
    CANCELLED,
    @SerialName("expired")
    EXPIRED,
}

@Serializable
enum class OfferStatus {
    @SerialName("pending")
    PENDING,
    @SerialName("accepted")
    ACCEPTED,
    @SerialName("declined")
    DECLINED,
    @SerialName("withdrawn")
    WITHDRAWN,
    @SerialName("expired")
    EXPIRED,
}
