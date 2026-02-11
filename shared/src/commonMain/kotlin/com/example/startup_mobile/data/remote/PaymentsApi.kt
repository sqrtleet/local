package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.common.MessageResponseDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.parameters
import kotlinx.serialization.json.JsonObject

interface PaymentsApi {
    suspend fun initiatePayment(bookingId: Int, returnUrl: String): JsonObject?
    suspend fun cloudPaymentsWebhook(): JsonObject?
    suspend fun getPaymentStatus(bookingId: Int): JsonObject?
    suspend fun requestRefund(bookingId: Int, reason: String): MessageResponseDto?
}

class DefaultPaymentsApi(
    private val http: HttpClient,
) : PaymentsApi {
    override suspend fun initiatePayment(bookingId: Int, returnUrl: String): JsonObject? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/payments/booking/$bookingId/initiate") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        append("return_url", returnUrl)
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun cloudPaymentsWebhook(): JsonObject? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/payments/webhook/cloudpayments")
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun getPaymentStatus(bookingId: Int): JsonObject? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/payments/booking/$bookingId") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun requestRefund(bookingId: Int, reason: String): MessageResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/payments/booking/$bookingId/refund") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        append("reason", reason)
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }
}
