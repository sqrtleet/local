package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.domain.CreateProviderPayload
import com.example.startup_mobile.domain.Provider
import com.example.startup_mobile.domain.UpdateProviderPayload

interface ProvidersRepository {
    suspend fun getProviders(
        page: Int? = null,
        perPage: Int? = null,
        region: String? = null,
        specialization: String? = null,
        search: String? = null,
        verifiedOnly: Boolean? = true,
    ): PaginatedResponse<Provider>

    suspend fun getProvider(id: Int): Provider?
    suspend fun getMyProviderProfile(): Provider?
    suspend fun createProvider(payload: CreateProviderPayload): Provider?
    suspend fun updateMyProviderProfile(payload: UpdateProviderPayload): Provider?
    suspend fun uploadProviderDocument(
        fileBytes: ByteArray,
        fileName: String,
        documentType: String,
    ): Provider?
    suspend fun getRegions(): List<String>
    suspend fun getSpecializations(): List<String>
    suspend fun getPendingVerifications(
        page: Int? = null,
        perPage: Int? = null,
    ): PaginatedResponse<Provider>

    suspend fun verifyProvider(providerId: Int, status: com.example.startup_mobile.domain.VerificationStatus, note: String?): Provider?
}
