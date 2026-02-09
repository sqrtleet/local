# План разработки KMP-приложения (туризм/отдых)

## Фаза 0: Подготовка проекта

1. **Структура пакетов в `shared`** — commonMain: `domain`, `data`, `di`, `platform`; androidMain/iosMain: `platform`.
2. **Версии и зависимости** — Ktor, kotlinx-datetime, kotlinx-coroutines, Ktor engines.
3. **Базовые expect/actual** — PlatformContext, Logger.
4. **Модели данных** — User, Trip, Booking, Payment, Media в `domain`.

## Фаза 1: Сеть и данные

5. **API-клиент** — Ktor в commonMain, JSON, DTO в `data`, маппинг DTO → domain.
6. **Репозитории** — интерфейсы и реализации (AuthRepository, ToursRepository, BookingsRepository).
7. **Локальное хранилище** — KeyValueStorage expect/actual (DataStore/UserDefaults).

## Фаза 2: Состояние и навигация

8. **Состояние** — ViewModel-подобные классы в shared или MVI/MVVM.
9. **Навигация** — sealed class маршрутов в shared.
10. **Минимальный экран** — список туров/главная на Compose и SwiftUI.

## Фаза 3: Платформенные возможности

11. Геолокация (LocationProvider expect/actual).
12. Уведомления (NotificationService expect/actual).
13. Медиа (интерфейс выбора/загрузки, actual на платформах).
14. Платежи (модели в shared, PaymentProvider контракт, реализация на платформах).

## Фаза 4: Качество и поддержка

15. Логирование (единый интерфейс, actual на платформах).
16. Обработка ошибок (Result/сеaled в shared).
17. Тесты в shared (репозитории, маппинги, Ktor mock).
18. Документация (README в shared, корневой README).

## Порядок выполнения

Сначала: Фаза 0 (1–4) и начало Фазы 1 (5–6). Затем п. 7, 8–10, далее Фаза 3 по одному пункту, в конце Фаза 4.
