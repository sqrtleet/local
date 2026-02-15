package com.example.startup_mobile.data.repository

import com.example.startup_mobile.domain.User

/**
 * High-level auth operations (e.g. current user). For token storage use [SessionRepository].
 */
interface AuthRepository {
    suspend fun getCurrentUser(): User?
}
