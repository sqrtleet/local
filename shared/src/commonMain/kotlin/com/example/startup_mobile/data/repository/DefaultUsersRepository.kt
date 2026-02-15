package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.mapping.toDto
import com.example.startup_mobile.data.remote.UsersApi
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.UpdateUserProfilePayload
import com.example.startup_mobile.domain.User
import com.example.startup_mobile.domain.UserRole
import com.example.startup_mobile.domain.UserStatus
import com.example.startup_mobile.domain.UserStatusUpdatePayload
import com.example.startup_mobile.domain.repository.UsersRepository

class DefaultUsersRepository(
    private val api: UsersApi,
) : UsersRepository {
    override suspend fun listUsers(
        page: Int?,
        perPage: Int?,
        role: UserRole?,
        status: UserStatus?,
        search: String?,
    ): Page<User> {
        val response = api.listUsers(page, perPage, role?.toDto(), status?.toDto(), search)
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }

    override suspend fun getMyProfile(): User? = api.getMyProfile()?.toDomain()

    override suspend fun updateMyProfile(body: UpdateUserProfilePayload): User? =
        api.updateMyProfile(body.toDto())?.toDomain()

    override suspend fun getUser(id: Int): User? = api.getUser(id)?.toDomain()

    override suspend fun deleteUser(id: Int): com.example.startup_mobile.domain.MessageResult? =
        api.deleteUser(id)?.toDomain()

    override suspend fun updateUserStatus(id: Int, body: UserStatusUpdatePayload): User? =
        api.updateUserStatus(id, body.toDto())?.toDomain()

    override suspend fun updateUserRole(id: Int, role: UserRole): User? =
        api.updateUserRole(id, role.toDto())?.toDomain()
}
