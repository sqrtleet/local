package com.example.startup_mobile.data.repository

import com.example.startup_mobile.domain.User

interface AuthRepository {
    suspend fun getCurrentUser(): User?
    fun getToken(): String?
    fun setToken(token: String?)
    fun clearToken()
}
