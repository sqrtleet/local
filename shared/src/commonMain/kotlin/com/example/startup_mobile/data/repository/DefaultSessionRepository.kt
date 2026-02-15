package com.example.startup_mobile.data.repository

import com.example.startup_mobile.domain.repository.SessionRepository
import com.example.startup_mobile.platform.KeyValueStorage

private const val KEY_TOKEN = "auth_token"

class DefaultSessionRepository(
    private val storage: KeyValueStorage,
) : SessionRepository {
    override fun getToken(): String? = storage.getString(KEY_TOKEN)

    override fun setToken(token: String?) {
        if (token != null) storage.putString(KEY_TOKEN, token)
        else storage.remove(KEY_TOKEN)
    }

    override fun clearToken() = storage.remove(KEY_TOKEN)
}
