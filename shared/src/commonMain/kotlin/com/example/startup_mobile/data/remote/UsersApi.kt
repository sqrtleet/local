package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.common.MessageResponseDto
import com.example.startup_mobile.data.dto.users.UserDto
import com.example.startup_mobile.data.dto.users.UserListResponseDto
import com.example.startup_mobile.data.dto.users.UserRole
import com.example.startup_mobile.data.dto.users.UserStatus
import com.example.startup_mobile.data.dto.users.UserStatusUpdateDto
import com.example.startup_mobile.data.dto.users.UserUpdateDto
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.parameters

interface UsersApi {
    suspend fun listUsers(
        page: Int? = null,
        perPage: Int? = null,
        role: UserRole? = null,
        status: UserStatus? = null,
        search: String? = null,
    ): PaginatedResponse<UserListResponseDto>

    suspend fun getMyProfile(): UserDto?
    suspend fun updateMyProfile(body: UserUpdateDto): UserDto?
    suspend fun getUser(id: Int): UserDto?
    suspend fun deleteUser(id: Int): MessageResponseDto?
    suspend fun updateUserStatus(id: Int, body: UserStatusUpdateDto): UserDto?
    suspend fun updateUserRole(id: Int, role: UserRole): UserDto?
}

class DefaultUsersApi(
    private val http: HttpClient,
) : UsersApi {
    override suspend fun listUsers(
        page: Int?,
        perPage: Int?,
        role: UserRole?,
        status: UserStatus?,
        search: String?,
    ): PaginatedResponse<UserListResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/users") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                        role?.let { append("role", it.name.lowercase()) }
                        status?.let { append("_status", it.name.lowercase()) }
                        search?.takeIf { it.isNotBlank() }?.let { append("search", it) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun getMyProfile(): UserDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/users/me") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateMyProfile(body: UserUpdateDto): UserDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/users/me") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun getUser(id: Int): UserDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/users/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun deleteUser(id: Int): MessageResponseDto? {
        val response: HttpResponse = http.client.delete("${http.baseUrl}/users/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateUserStatus(id: Int, body: UserStatusUpdateDto): UserDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/users/$id/status") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateUserRole(id: Int, role: UserRole): UserDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/users/$id/role") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        append("role", role.name.lowercase())
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    private fun <T> emptyPaginatedResponse(
        page: Int?,
        perPage: Int?,
    ): PaginatedResponse<T> = PaginatedResponse(
        items = emptyList(),
        total = 0,
        page = page ?: 1,
        perPage = perPage ?: 0,
        pages = 0,
    )
}
