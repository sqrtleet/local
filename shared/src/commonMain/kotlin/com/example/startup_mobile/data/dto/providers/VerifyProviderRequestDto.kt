package com.example.startup_mobile.data.dto.providers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerifyProviderRequestDto(
    @SerialName("verification_status") val verificationStatus: String,
    @SerialName("verification_note") val verificationNote: String? = null,
)
