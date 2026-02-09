package com.example.startup_mobile.platform

actual fun getPlatformContext(): PlatformContext = IosPlatformContext()

internal class IosPlatformContext : PlatformContext {
    override val baseUrl: String
        get() = getKeyValueStorage().getString(DefaultConfig.BASE_URL_KEY) ?: DefaultConfig.baseUrl
    override val isDebug: Boolean
        get() = true
}
