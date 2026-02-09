package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.remote.AuthApi
import com.example.startup_mobile.domain.User
import com.example.startup_mobile.platform.getKeyValueStorage

private const val KEY_TOKEN = "auth_token"

class DefaultAuthRepository(
    private val api: AuthApi,
    private val storage: com.example.startup_mobile.platform.KeyValueStorage = getKeyValueStorage(),
) : AuthRepository {
    override suspend fun getCurrentUser(): User? = api.getCurrentUser()?.toDomain()
    override fun getToken(): String? = storage.getString(KEY_TOKEN)
    override fun setToken(token: String?) {
        if (token != null) storage.putString(KEY_TOKEN, token)
        else storage.remove(KEY_TOKEN)
    }
    override fun clearToken() = storage.remove(KEY_TOKEN)
}
