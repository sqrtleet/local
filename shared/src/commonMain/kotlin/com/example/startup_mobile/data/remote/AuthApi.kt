package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.users.UserDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

interface AuthApi {
    suspend fun getCurrentUser(): UserDto?
}

class DefaultAuthApi(
    private val http: HttpClient,
) : AuthApi {
    override suspend fun getCurrentUser(): UserDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/me") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }
}
