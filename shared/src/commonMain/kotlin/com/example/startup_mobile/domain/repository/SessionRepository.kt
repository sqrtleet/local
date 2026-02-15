package com.example.startup_mobile.domain.repository

/**
 * Contract for auth token storage. Single source of truth for token used by HTTP client and login flow.
 */
interface SessionRepository {
    fun getToken(): String?
    fun setToken(token: String?)
    fun clearToken()
}
