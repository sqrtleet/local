package com.example.startup_mobile.data.repository

import com.example.startup_mobile.domain.CreateProviderPayload
import com.example.startup_mobile.domain.Provider
import com.example.startup_mobile.domain.UpdateProviderPayload

interface ProvidersRepository {
    suspend fun getProviders(): List<Provider>
    suspend fun getProvider(id: Int): Provider?
    suspend fun getMyProviderProfile(): Provider?
    suspend fun createProvider(payload: CreateProviderPayload): Provider?
    suspend fun updateMyProviderProfile(payload: UpdateProviderPayload): Provider?
    suspend fun uploadProviderDocument(fileBytes: ByteArray, fileName: String): Boolean
    suspend fun getRegions(): List<String>
    suspend fun getSpecializations(): List<String>
    suspend fun getPendingVerifications(): List<Provider>
    suspend fun verifyProvider(providerId: Int, verificationStatus: String, verificationNote: String?): Provider?
}
