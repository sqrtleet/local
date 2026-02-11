package com.example.startup_mobile.data.remote

import com.example.startup_mobile.platform.createHttpClient
import com.example.startup_mobile.platform.getPlatformContext
import io.ktor.client.HttpClient as KtorHttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Shared HTTP client configuration. All domain APIs (ProvidersApi, ToursApi, etc.)
 * receive this and use [client], [baseUrl] and [authHeader] for requests.
 */
class HttpClient(
    val baseUrl: String = run {
        val rawBaseUrl = getPlatformContext().baseUrl.trimEnd('/')
        if (rawBaseUrl.endsWith("/api/v1")) rawBaseUrl else "$rawBaseUrl/api/v1"
    },
    val tokenProvider: (() -> String?)? = null,
) {
    val client: KtorHttpClient = createHttpClient {
        expectSuccess = false
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
        install(Logging) {
            level = LogLevel.INFO
        }
    }

    fun authHeader(): String? = tokenProvider?.invoke()
}
