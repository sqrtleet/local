package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.providers.CreateProviderRequestDto
import com.example.startup_mobile.data.dto.providers.ProviderListResponseDto
import com.example.startup_mobile.data.dto.providers.ProviderResponseDto
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
import io.ktor.http.parameters

interface ProvidersApi {
    suspend fun getProviders(
        page: Int? = null,
        perPage: Int? = null,
        region: String? = null,
        specialization: String? = null,
        search: String? = null,
        verifiedOnly: Boolean? = true,
    ): PaginatedResponse<ProviderListResponseDto>

    suspend fun getProvider(id: Int): ProviderResponseDto?
    suspend fun createProvider(body: CreateProviderRequestDto): ProviderResponseDto?
    suspend fun getMyProviderProfile(): ProviderResponseDto?
    suspend fun updateMyProviderProfile(body: UpdateProviderRequestDto): ProviderResponseDto?
    suspend fun uploadProviderDocument(
        fileBytes: ByteArray,
        fileName: String,
        documentType: String,
    ): ProviderResponseDto?

    suspend fun getRegions(): List<String>
    suspend fun getSpecializations(): List<String>
    suspend fun getPendingVerifications(
        page: Int? = null,
        perPage: Int? = null,
    ): PaginatedResponse<ProviderListResponseDto>

    suspend fun verifyProvider(providerId: Int, body: VerifyProviderRequestDto): ProviderResponseDto?
}

class DefaultProvidersApi(
    private val http: HttpClient,
) : ProvidersApi {
    override suspend fun getProviders(
        page: Int?,
        perPage: Int?,
        region: String?,
        specialization: String?,
        search: String?,
        verifiedOnly: Boolean?,
    ): PaginatedResponse<ProviderListResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers") {
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                        region?.takeIf { it.isNotBlank() }?.let { append("region", it) }
                        specialization?.takeIf { it.isNotBlank() }?.let { append("specialization", it) }
                        search?.takeIf { it.isNotBlank() }?.let { append("search", it) }
                        verifiedOnly?.let { append("verified_only", it.toString()) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun getProvider(id: Int): ProviderResponseDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun createProvider(body: CreateProviderRequestDto): ProviderResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/providers") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK, HttpStatusCode.Created -> response.body()
            else -> null
        }
    }

    override suspend fun getMyProviderProfile(): ProviderResponseDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers/me") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateMyProviderProfile(body: UpdateProviderRequestDto): ProviderResponseDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/providers/me") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun uploadProviderDocument(
        fileBytes: ByteArray,
        fileName: String,
        documentType: String,
    ): ProviderResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/providers/me/documents") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        append("document_type", documentType)
                    }
                )
            }
            setBody(
                MultiPartFormDataContent(
                    formData {
                        append(
                            "file",
                            fileBytes,
                            Headers.build {
                                append(
                                    HttpHeaders.ContentDisposition,
                                    "form-data; name=\"file\"; filename=\"$fileName\""
                                )
                            }
                        )
                    }
                )
            )
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
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

    override suspend fun getPendingVerifications(
        page: Int?,
        perPage: Int?,
    ): PaginatedResponse<ProviderListResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/providers/pending") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun verifyProvider(providerId: Int, body: VerifyProviderRequestDto): ProviderResponseDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/providers/$providerId/verify") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    private fun <T> emptyPaginatedResponse(
        page: Int?,
        perPage: Int?,
    ): PaginatedResponse<T> = PaginatedResponse(
        items = emptyList(),
        total = 0,
        page = page ?: 1,
        perPage = perPage ?: 0,
        pages = 0,
    )
}
