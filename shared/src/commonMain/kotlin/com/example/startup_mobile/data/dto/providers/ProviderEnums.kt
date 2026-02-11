package com.example.startup_mobile.data.dto.providers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class VerificationStatus {
    @SerialName("pending")
    PENDING,
    @SerialName("approved")
    APPROVED,
    @SerialName("rejected")
    REJECTED,
}
