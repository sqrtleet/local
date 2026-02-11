package com.example.startup_mobile.data.remote

import com.example.startup_mobile.data.dto.PaginatedResponse
import com.example.startup_mobile.data.dto.travelRequests.OfferAcceptDto
import com.example.startup_mobile.data.dto.travelRequests.OfferDeclineDto
import com.example.startup_mobile.data.dto.travelRequests.OfferStatus
import com.example.startup_mobile.data.dto.travelRequests.ProviderOfferCreateDto
import com.example.startup_mobile.data.dto.travelRequests.ProviderOfferListResponseDto
import com.example.startup_mobile.data.dto.travelRequests.ProviderOfferResponseDto
import com.example.startup_mobile.data.dto.travelRequests.ProviderOfferUpdateDto
import com.example.startup_mobile.data.dto.travelRequests.RequestStatus
import com.example.startup_mobile.data.dto.travelRequests.TravelRequestCreateDto
import com.example.startup_mobile.data.dto.travelRequests.TravelRequestListResponse
import com.example.startup_mobile.data.dto.travelRequests.TravelRequestResponse
import com.example.startup_mobile.data.dto.travelRequests.TravelRequestUpdateDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.parameters

interface TravelRequestsApi {
    suspend fun getAvailableRequests(
        page: Int? = null,
        perPage: Int? = null,
        region: String? = null,
        categories: List<String> = emptyList(),
    ): PaginatedResponse<TravelRequestListResponse>

    suspend fun getMyRequests(
        page: Int? = null,
        perPage: Int? = null,
        status: RequestStatus? = null,
    ): PaginatedResponse<TravelRequestListResponse>

    suspend fun createRequest(body: TravelRequestCreateDto): TravelRequestResponse?
    suspend fun getRequest(id: Int): TravelRequestResponse?
    suspend fun updateRequest(id: Int, body: TravelRequestUpdateDto): TravelRequestResponse?
    suspend fun cancelRequest(id: Int): TravelRequestResponse?
    suspend fun getRequestOffers(
        requestId: Int,
        status: OfferStatus? = null,
    ): List<ProviderOfferResponseDto>

    suspend fun getAvailableRequest(id: Int): TravelRequestResponse?
    suspend fun getMyOffers(
        page: Int? = null,
        perPage: Int? = null,
        status: OfferStatus? = null,
    ): PaginatedResponse<ProviderOfferListResponseDto>

    suspend fun createOffer(body: ProviderOfferCreateDto): ProviderOfferResponseDto?
    suspend fun getOffer(id: Int): ProviderOfferResponseDto?
    suspend fun updateOffer(id: Int, body: ProviderOfferUpdateDto): ProviderOfferResponseDto?
    suspend fun withdrawOffer(id: Int): ProviderOfferResponseDto?
    suspend fun acceptOffer(id: Int, body: OfferAcceptDto): ProviderOfferResponseDto?
    suspend fun declineOffer(id: Int, body: OfferDeclineDto): ProviderOfferResponseDto?
}

class DefaultTravelRequestsApi(
    private val http: HttpClient,
) : TravelRequestsApi {
    override suspend fun getAvailableRequests(
        page: Int?,
        perPage: Int?,
        region: String?,
        categories: List<String>,
    ): PaginatedResponse<TravelRequestListResponse> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/requests/available") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                        region?.takeIf { it.isNotBlank() }?.let { append("region", it) }
                        categories.forEach { append("categories", it) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun getMyRequests(
        page: Int?,
        perPage: Int?,
        status: RequestStatus?,
    ): PaginatedResponse<TravelRequestListResponse> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/requests/my") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                        status?.let { append("_status", it.name.lowercase()) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun createRequest(body: TravelRequestCreateDto): TravelRequestResponse? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/requests") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK, HttpStatusCode.Created -> response.body()
            else -> null
        }
    }

    override suspend fun getRequest(id: Int): TravelRequestResponse? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/requests/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateRequest(id: Int, body: TravelRequestUpdateDto): TravelRequestResponse? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/requests/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun cancelRequest(id: Int): TravelRequestResponse? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/requests/$id/cancel") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun getRequestOffers(
        requestId: Int,
        status: OfferStatus?,
    ): List<ProviderOfferResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/requests/$requestId/offers") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        status?.let { append("_status", it.name.lowercase()) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyList()
        }
    }

    override suspend fun getAvailableRequest(id: Int): TravelRequestResponse? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/requests/available/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun getMyOffers(
        page: Int?,
        perPage: Int?,
        status: OfferStatus?,
    ): PaginatedResponse<ProviderOfferListResponseDto> {
        val response: HttpResponse = http.client.get("${http.baseUrl}/requests/offers/my") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            url {
                parameters.appendAll(
                    parameters {
                        page?.let { append("page", it.toString()) }
                        perPage?.let { append("per_page", it.toString()) }
                        status?.let { append("_status", it.name.lowercase()) }
                    }
                )
            }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> emptyPaginatedResponse(page, perPage)
        }
    }

    override suspend fun createOffer(body: ProviderOfferCreateDto): ProviderOfferResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/requests/offers") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK, HttpStatusCode.Created -> response.body()
            else -> null
        }
    }

    override suspend fun getOffer(id: Int): ProviderOfferResponseDto? {
        val response: HttpResponse = http.client.get("${http.baseUrl}/requests/offers/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun updateOffer(id: Int, body: ProviderOfferUpdateDto): ProviderOfferResponseDto? {
        val response: HttpResponse = http.client.put("${http.baseUrl}/requests/offers/$id") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun withdrawOffer(id: Int): ProviderOfferResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/requests/offers/$id/withdraw") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun acceptOffer(id: Int, body: OfferAcceptDto): ProviderOfferResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/requests/offers/$id/accept") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
        }
        return when (response.status) {
            HttpStatusCode.OK -> response.body()
            else -> null
        }
    }

    override suspend fun declineOffer(id: Int, body: OfferDeclineDto): ProviderOfferResponseDto? {
        val response: HttpResponse = http.client.post("${http.baseUrl}/requests/offers/$id/decline") {
            http.authHeader()?.let { header("Authorization", "Bearer $it") }
            setBody(body)
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
