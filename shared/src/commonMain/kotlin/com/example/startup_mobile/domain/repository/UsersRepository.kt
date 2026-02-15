package com.example.startup_mobile.domain.repository

import com.example.startup_mobile.domain.User
import com.example.startup_mobile.domain.UserRole
import com.example.startup_mobile.domain.UserStatus
import com.example.startup_mobile.domain.UserStatusUpdatePayload
import com.example.startup_mobile.domain.UpdateUserProfilePayload
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.MessageResult

interface UsersRepository {
    suspend fun listUsers(
        page: Int? = null,
        perPage: Int? = null,
        role: UserRole? = null,
        status: UserStatus? = null,
        search: String? = null,
    ): Page<User>

    suspend fun getMyProfile(): User?
    suspend fun updateMyProfile(body: UpdateUserProfilePayload): User?
    suspend fun getUser(id: Int): User?
    suspend fun deleteUser(id: Int): MessageResult?
    suspend fun updateUserStatus(id: Int, body: UserStatusUpdatePayload): User?
    suspend fun updateUserRole(id: Int, role: UserRole): User?
}
