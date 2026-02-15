package com.example.startup_mobile.data.repository

import com.example.startup_mobile.data.mapping.toDomain
import com.example.startup_mobile.data.mapping.toDto
import com.example.startup_mobile.data.remote.TravelRequestsApi
import com.example.startup_mobile.domain.AcceptOfferPayload
import com.example.startup_mobile.domain.CreateTravelRequestOfferPayload
import com.example.startup_mobile.domain.CreateTravelRequestPayload
import com.example.startup_mobile.domain.DeclineOfferPayload
import com.example.startup_mobile.domain.OfferStatus
import com.example.startup_mobile.domain.Page
import com.example.startup_mobile.domain.RequestStatus
import com.example.startup_mobile.domain.TravelRequest
import com.example.startup_mobile.domain.TravelRequestOffer
import com.example.startup_mobile.domain.UpdateTravelRequestOfferPayload
import com.example.startup_mobile.domain.UpdateTravelRequestPayload
import com.example.startup_mobile.domain.repository.TravelRequestsRepository

class DefaultTravelRequestsRepository(private val api: TravelRequestsApi) : TravelRequestsRepository {
    override suspend fun getAvailableRequests(page: Int?, perPage: Int?, region: String?, categories: List<String>, ): Page<TravelRequest> {
        val response = api.getAvailableRequests(page, perPage, region, categories)
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }
    override suspend fun getMyRequests(page: Int?, perPage: Int?, status: RequestStatus?): Page<TravelRequest> {
        val response = api.getMyRequests(page, perPage, status?.toDto())
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }
    override suspend fun createRequest(body: CreateTravelRequestPayload): TravelRequest? = api.createRequest(body.toDto())?.toDomain()
    override suspend fun getRequest(id: Int): TravelRequest? = api.getRequest(id)?.toDomain()
    override suspend fun updateRequest(id: Int, body: UpdateTravelRequestPayload): TravelRequest? = api.updateRequest(id, body.toDto())?.toDomain()
    override suspend fun cancelRequest(id: Int): TravelRequest? = api.cancelRequest(id)?.toDomain()
    override suspend fun getRequestOffers(requestId: Int, status: OfferStatus?): List<TravelRequestOffer> = api.getRequestOffers(requestId, status?.toDto()).map { it.toDomain() }
    override suspend fun getAvailableRequest(id: Int): TravelRequest? = api.getAvailableRequest(id)?.toDomain()
    override suspend fun getMyOffers(page: Int?, perPage: Int?, status: OfferStatus?): Page<TravelRequestOffer> {
        val response = api.getMyOffers(page, perPage, status?.toDto())
        return Page(
            items = response.items.map { it.toDomain() },
            total = response.total,
            page = response.page,
            perPage = response.perPage,
            pages = response.pages,
        )
    }
    override suspend fun createOffer(body: CreateTravelRequestOfferPayload): TravelRequestOffer? = api.createOffer(body.toDto())?.toDomain()
    override suspend fun getOffer(id: Int): TravelRequestOffer? = api.getOffer(id)?.toDomain()
    override suspend fun updateOffer(id: Int, body: UpdateTravelRequestOfferPayload): TravelRequestOffer? = api.updateOffer(id, body.toDto())?.toDomain()
    override suspend fun withdrawOffer(id: Int): TravelRequestOffer? = api.withdrawOffer(id)?.toDomain()
    override suspend fun acceptOffer(id: Int, body: AcceptOfferPayload): TravelRequestOffer? = api.acceptOffer(id, body.toDto())?.toDomain()
    override suspend fun declineOffer(id: Int, body: DeclineOfferPayload): TravelRequestOffer? = api.declineOffer(id, body.toDto())?.toDomain()
}
