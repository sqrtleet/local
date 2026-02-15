package com.example.startup_mobile.domain

data class PaymentDetails(
    val bankName: String? = null,
    val accountNumber: String? = null,
    val cardNumber: String? = null,
    val phone: String? = null,
)
