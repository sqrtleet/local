# Shared (KMP)

Общий код для Android и iOS.

## Пакеты

- **domain** — доменные модели: `User`, `Trip`, `Booking`, `Payment`, `Media`, `Money`, enum'ы статусов.
- **data** — слой данных:
  - **dto** — DTO с `@Serializable` для API.
  - **mapping** — маппинг DTO → domain (`DtoMappers.kt`).
  - **remote** — `ApiClient`, `createDefaultApiClient()`.
  - **repository** — интерфейсы репозиториев и реализации (`Default*Repository`).
- **platform** — expect/actual для платформенных вещей:
  - **commonMain**: `PlatformContext`, `Logger`, `KeyValueStorage`, `HttpClientFactory` (expect).
  - **androidMain** / **iosMain**: actual-реализации.

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
