package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.remote.PaymentsApi
import com.example.startup_mobile.domain.repository.PaymentsRepository
import kotlinx.serialization.json.JsonObject

class DefaultPaymentsRepository(
    private val api: PaymentsApi,
) : PaymentsRepository {
    override suspend fun initiatePayment(bookingId: Int, returnUrl: String): JsonObject? =
        api.initiatePayment(bookingId, returnUrl)

    override suspend fun getPaymentStatus(bookingId: Int): JsonObject? =
        api.getPaymentStatus(bookingId)

    override suspend fun requestRefund(bookingId: Int, reason: String): com.example.startup_mobile.domain.MessageResult? =
        api.requestRefund(bookingId, reason)?.toDomain()
}
