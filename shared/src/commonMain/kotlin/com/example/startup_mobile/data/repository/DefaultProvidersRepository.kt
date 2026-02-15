package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.dto.providers.VerifyProviderRequestDto
import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.mapping.toDto
import com.example.startup_mobile.data.remote.ProvidersApi
import com.example.startup_mobile.domain.CreateProviderPayload
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.Provider
import com.example.startup_mobile.domain.UpdateProviderPayload
import com.example.startup_mobile.domain.VerificationStatus
import com.example.startup_mobile.domain.repository.ProvidersRepository

class DefaultProvidersRepository(
    private val api: ProvidersApi,
) : ProvidersRepository {
    override suspend fun getProviders(
        page: Int?,
        perPage: Int?,
        region: String?,
        specialization: String?,
        search: String?,
        verifiedOnly: Boolean?,
    ): Page<Provider> {
        val response = api.getProviders(page, perPage, region, specialization, search, verifiedOnly)
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun getProvider(id: Int): Provider? = api.getProvider(id)?.toDomain()
    override suspend fun getMyProviderProfile(): Provider? = api.getMyProviderProfile()?.toDomain()
    override suspend fun createProvider(payload: CreateProviderPayload): Provider? =
        api.createProvider(payload.toDto())?.toDomain()

    override suspend fun updateMyProviderProfile(payload: UpdateProviderPayload): Provider? =
        api.updateMyProviderProfile(payload.toDto())?.toDomain()

    override suspend fun uploadProviderDocument(
        fileBytes: ByteArray,
        fileName: String,
        documentType: String,
    ): Provider? = api.uploadProviderDocument(fileBytes, fileName, documentType)?.toDomain()

    override suspend fun getRegions(): List<String> = api.getRegions()
    override suspend fun getSpecializations(): List<String> = api.getSpecializations()
    override suspend fun getPendingVerifications(
        page: Int?,
        perPage: Int?,
    ): Page<Provider> {
        val response = api.getPendingVerifications(page, perPage)
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun verifyProvider(
        providerId: Int,
        status: VerificationStatus,
        note: String?,
    ): Provider? = api.verifyProvider(
        providerId,
        VerifyProviderRequestDto(status = status.toDto(), note = note),
    )?.toDomain()
}
