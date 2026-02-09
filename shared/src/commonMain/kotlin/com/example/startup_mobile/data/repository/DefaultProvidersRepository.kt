package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.dto.providers.VerifyProviderRequestDto
import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.mapping.toDto
import com.example.startup_mobile.data.remote.ProvidersApi
import com.example.startup_mobile.domain.CreateProviderPayload
import com.example.startup_mobile.domain.Provider
import com.example.startup_mobile.domain.UpdateProviderPayload

class DefaultProvidersRepository(
    private val api: ProvidersApi,
) : ProvidersRepository {
    override suspend fun getProviders(): List<Provider> = api.getProviders().map { it.toDomain() }
    override suspend fun getProvider(id: Int): Provider? = api.getProvider(id)?.toDomain()
    override suspend fun getMyProviderProfile(): Provider? = api.getMyProviderProfile()?.toDomain()
    override suspend fun createProvider(payload: CreateProviderPayload): Provider? =
        api.createProvider(payload.toDto())?.toDomain()
    override suspend fun updateMyProviderProfile(payload: UpdateProviderPayload): Provider? =
        api.updateMyProviderProfile(payload.toDto())?.toDomain()
    override suspend fun uploadProviderDocument(fileBytes: ByteArray, fileName: String): Boolean =
        api.uploadProviderDocument(fileBytes, fileName)
    override suspend fun getRegions(): List<String> = api.getRegions()
    override suspend fun getSpecializations(): List<String> = api.getSpecializations()
    override suspend fun getPendingVerifications(): List<Provider> =
        api.getPendingVerifications().map { it.toDomain() }
    override suspend fun verifyProvider(
        providerId: Int,
        verificationStatus: String,
        verificationNote: String?,
    ): Provider? = api.verifyProvider(
        providerId,
        VerifyProviderRequestDto(verificationStatus = verificationStatus, verificationNote = verificationNote),
    )?.toDomain()
}
