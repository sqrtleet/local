package com.example.startup_mobile.di

import com.example.startup_mobile.data.remote.AuthApi
import com.example.startup_mobile.data.remote.BookingsApi
import com.example.startup_mobile.data.remote.DefaultAuthApi
import com.example.startup_mobile.data.remote.DefaultBookingsApi
import com.example.startup_mobile.data.remote.DefaultPaymentsApi
import com.example.startup_mobile.data.remote.DefaultProvidersApi
import com.example.startup_mobile.data.remote.DefaultReviewsApi
import com.example.startup_mobile.data.remote.DefaultToursApi
import com.example.startup_mobile.data.remote.DefaultTravelRequestsApi
import com.example.startup_mobile.data.remote.DefaultUsersApi
import com.example.startup_mobile.data.remote.HttpClient
import com.example.startup_mobile.data.remote.PaymentsApi
import com.example.startup_mobile.data.remote.ProvidersApi
import com.example.startup_mobile.data.remote.ReviewsApi
import com.example.startup_mobile.data.remote.TravelRequestsApi
import com.example.startup_mobile.data.remote.ToursApi
import com.example.startup_mobile.data.remote.UsersApi
import com.example.startup_mobile.data.repository.AuthRepository
import com.example.startup_mobile.data.repository.DefaultAuthRepository
import com.example.startup_mobile.data.repository.DefaultBookingsRepository
import com.example.startup_mobile.data.repository.DefaultPaymentsRepository
import com.example.startup_mobile.data.repository.DefaultProvidersRepository
import com.example.startup_mobile.data.repository.DefaultReviewsRepository
import com.example.startup_mobile.data.repository.DefaultToursRepository
import com.example.startup_mobile.data.repository.DefaultTravelRequestsRepository
import com.example.startup_mobile.data.repository.DefaultUsersRepository
import com.example.startup_mobile.domain.repository.BookingsRepository
import com.example.startup_mobile.domain.repository.PaymentsRepository
import com.example.startup_mobile.domain.repository.ProvidersRepository
import com.example.startup_mobile.domain.repository.ReviewsRepository
import com.example.startup_mobile.domain.repository.TravelRequestsRepository
import com.example.startup_mobile.domain.repository.ToursRepository
import com.example.startup_mobile.domain.repository.UsersRepository
import com.example.startup_mobile.data.remote.createDefaultHttpClient
import com.example.startup_mobile.domain.repository.SessionRepository
import com.example.startup_mobile.platform.getKeyValueStorage

/**
 * Single place that builds HttpClient → *Api → repositories.
 * Use repositories in UI/ViewModels; do not access data.remote directly.
 */
object AppContainer {
    val sessionRepository: SessionRepository by lazy {
        com.example.startup_mobile.data.repository.DefaultSessionRepository(getKeyValueStorage())
    }

    private val httpClient: HttpClient by lazy {
        createDefaultHttpClient(tokenProvider = { sessionRepository.getToken() })
    }

    private val providersApi: ProvidersApi by lazy { DefaultProvidersApi(httpClient) }
    private val toursApi: ToursApi by lazy { DefaultToursApi(httpClient) }
    private val bookingsApi: BookingsApi by lazy { DefaultBookingsApi(httpClient) }
    private val authApi: AuthApi by lazy { DefaultAuthApi(httpClient) }
    private val travelRequestsApi: TravelRequestsApi by lazy { DefaultTravelRequestsApi(httpClient) }
    private val usersApi: UsersApi by lazy { DefaultUsersApi(httpClient) }
    private val paymentsApi: PaymentsApi by lazy { DefaultPaymentsApi(httpClient) }
    private val reviewsApi: ReviewsApi by lazy { DefaultReviewsApi(httpClient) }

    val providersRepository: ProvidersRepository by lazy { DefaultProvidersRepository(providersApi) }
    val toursRepository: ToursRepository by lazy { DefaultToursRepository(toursApi) }
    val bookingsRepository: BookingsRepository by lazy { DefaultBookingsRepository(bookingsApi) }
    val authRepository: AuthRepository by lazy { DefaultAuthRepository(authApi) }
    val travelRequestsRepository: TravelRequestsRepository by lazy { DefaultTravelRequestsRepository(travelRequestsApi) }
    val usersRepository: UsersRepository by lazy { DefaultUsersRepository(usersApi) }
    val paymentsRepository: PaymentsRepository by lazy { DefaultPaymentsRepository(paymentsApi) }
    val reviewsRepository: ReviewsRepository by lazy { DefaultReviewsRepository(reviewsApi) }
}
