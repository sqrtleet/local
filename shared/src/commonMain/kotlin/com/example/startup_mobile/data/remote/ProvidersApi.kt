package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.providers.CreateProviderRequestDto
import com.example.startup_mobile.data.dto.providers.ProviderDto
import com.example.startup_mobile.data.dto.providers.UpdateProviderRequestDto
import com.example.startup_mobile.data.dto.providers.VerifyProviderRequestDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode

interface ProvidersApi {
    suspend fun getProviders(): List<ProviderDto>
    suspend fun getProvider(id: Int): ProviderDto?
    suspend fun createProvider(body: CreateProviderRequestDto): ProviderDto?
    suspend fun getMyProviderProfile(): ProviderDto?
    suspend fun updateMyProviderProfile(body: UpdateProviderRequestDto): ProviderDto?
    suspend fun uploadProviderDocument(fileBytes: ByteArray, fileName: String): Boolean
    suspend fun getRegions(): List<String>
    suspend fun getSpecializations(): List<String>
    suspend fun getPendingVerifications(): List<ProviderDto>
    suspend fun verifyProvider(providerId: Int, body: VerifyProviderRequestDto): ProviderDto?
}

class DefaultProvidersApi(
    private val http: HttpClient,
) : ProvidersApi {
    override suspend fun getProviders(): List<ProviderDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyList()
        }
    }

    override suspend fun getProvider(id: Int): ProviderDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun createProvider(body: CreateProviderRequestDto): ProviderDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/providers") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK, HttpStatusCode.Created -> response.body()
            else -> null
        }
    }

    override suspend fun getMyProviderProfile(): ProviderDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers/me") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateMyProviderProfile(body: UpdateProviderRequestDto): ProviderDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/providers/me") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun uploadProviderDocument(fileBytes: ByteArray, fileName: String): Boolean {
        val response: HttpResponse = http.client.post("${http.baseUrl}/providers/me/documents") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(
                MultiPartFormDataContent(
                    formData {
                        append(
                            "document",
                            fileBytes,
                            Headers.build {
                                append(
                                    HttpHeaders.ContentDisposition,
                                    "form-data; name=\"document\"; filename=\"$fileName\""
                                )
                            }
                        )
                    }
                )
            )
        }
        return response.status == HttpStatusCode.OK || response.status == HttpStatusCode.Created
    }

    override suspend fun getRegions(): List<String> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers/regions") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyList()
        }
    }

    override suspend fun getSpecializations(): List<String> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers/specializations") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyList()
        }
    }

    override suspend fun getPendingVerifications(): List<ProviderDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers/pending") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyList()
        }
    }

    override suspend fun verifyProvider(providerId: Int, body: VerifyProviderRequestDto): ProviderDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/providers/$providerId/verify") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }
}
