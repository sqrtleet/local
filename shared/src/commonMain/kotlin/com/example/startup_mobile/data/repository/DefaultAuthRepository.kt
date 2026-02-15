package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.remote.AuthApi
import com.example.startup_mobile.domain.User

class DefaultAuthRepository(
    private val api: AuthApi,
) : AuthRepository {
    override suspend fun getCurrentUser(): User? = api.getCurrentUser()?.toDomain()
}
