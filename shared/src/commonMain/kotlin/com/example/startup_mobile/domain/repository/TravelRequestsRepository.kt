package com.example.startup_mobile.domain.repository

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

interface TravelRequestsRepository {
    suspend fun getAvailableRequests(page: Int? = null, perPage: Int? = null, region: String? = null, categories: List<String> = emptyList()): Page<TravelRequest>
    suspend fun getMyRequests(page: Int? = null, perPage: Int? = null, status: RequestStatus? = null): Page<TravelRequest>
    suspend fun createRequest(body: CreateTravelRequestPayload): TravelRequest?
    suspend fun getRequest(id: Int): TravelRequest?
    suspend fun updateRequest(id: Int, body: UpdateTravelRequestPayload): TravelRequest?
    suspend fun cancelRequest(id: Int): TravelRequest?
    suspend fun getRequestOffers(requestId: Int, status: OfferStatus? = null): List<TravelRequestOffer>
    suspend fun getAvailableRequest(id: Int): TravelRequest?
    suspend fun getMyOffers(page: Int? = null, perPage: Int? = null, status: OfferStatus? = null): Page<TravelRequestOffer>
    suspend fun createOffer(body: CreateTravelRequestOfferPayload): TravelRequestOffer?
    suspend fun getOffer(id: Int): TravelRequestOffer?
    suspend fun updateOffer(id: Int, body: UpdateTravelRequestOfferPayload): TravelRequestOffer?
    suspend fun withdrawOffer(id: Int): TravelRequestOffer?
    suspend fun acceptOffer(id: Int, body: AcceptOfferPayload): TravelRequestOffer?
    suspend fun declineOffer(id: Int, body: DeclineOfferPayload): TravelRequestOffer?
}
