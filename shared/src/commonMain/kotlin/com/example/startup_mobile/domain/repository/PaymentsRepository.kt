package com.example.startup_mobile.domain.repository

import com.example.startup_mobile.domain.MessageResult
import kotlinx.serialization.json.JsonObject

interface PaymentsRepository {
    suspend fun initiatePayment(bookingId: Int, returnUrl: String): JsonObject?
    suspend fun getPaymentStatus(bookingId: Int): JsonObject?
    suspend fun requestRefund(bookingId: Int, reason: String): MessageResult?
}
