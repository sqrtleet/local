package com.example.startup_mobile.domain

data class AcceptOfferPayload(
    val contactName: String? = null,
    val contactPhone: String? = null,
    val contactEmail: String? = null,
    val notes: String? = null,
)
