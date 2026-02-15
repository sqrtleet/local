# Shared (KMP)

Общий код для Android и iOS.

## Пакеты

- **domain** — доменные модели и контракты репозиториев:
  - Модели: `User`, `Tour`, `Booking`, `Provider`, `TravelRequest`, `TravelRequestOffer`, `Review`, `Payment`, `Media`, enum'ы статусов.
  - **domain/repository** — интерфейсы репозиториев (только domain-типы и `Page<T>`): `ToursRepository`, `BookingsRepository`, `ProvidersRepository`, `AuthRepository` (high-level), `SessionRepository` (token), `TravelRequestsRepository`, `UsersRepository`, `PaymentsRepository`, `ReviewsRepository`.
- **data** — слой данных:
  - **dto** — DTO с `@Serializable` для API; пагинация в transport — `PaginatedResponse<T>`.
  - **mapping** — маппинг DTO ↔ domain (`DtoMappers.kt`).
  - **remote** — `HttpClient`, `createDefaultHttpClient(tokenProvider)`, *Api-интерфейсы и `Default*Api`.
  - **repository** — реализации репозиториев (`Default*Repository`), реализуют интерфейсы из `domain/repository`.
- **platform** — expect/actual:
  - **commonMain**: `PlatformContext`, `Logger`, `KeyValueStorage`, `HttpClientFactory` (expect).
  - **androidMain** / **iosMain**: actual-реализации.

## Composition root (DI)

`di/AppContainer` — единая точка сборки: создаёт `SessionRepository` (источник токена для HTTP), `HttpClient` с `tokenProvider = { sessionRepository.getToken() }`, все *Api и репозитории. В UI/ViewModels использовать только репозитории и `sessionRepository` из `AppContainer`; не обращаться к `data.remote` напрямую.

## Инициализация на Android

В `Application` или `MainActivity.onCreate` вызвать:

```kotlin
import com.example.startup_mobile.platform.initKeyValueStorage
initKeyValueStorage(applicationContext)
```

## Зависимости

- Ktor (client, content-negotiation, logging, okhttp/darwin engines).
- kotlinx-datetime, kotlinx-serialization.

## Добавление нового платформенного сервиса

1. В `commonMain` объявить интерфейс и `expect fun getX(): X` (или `expect class`).
2. В `androidMain` и `iosMain` добавить `actual`-реализации.

## Sample/debug код

`Greeting` и `Platform` — шаблонный демо-код, не часть бизнес-домена; помечены в коде как sample/debug.
