package com.example.startup_mobile.platform

import platform.Foundation.NSUserDefaults

actual fun getKeyValueStorage(): KeyValueStorage = IosKeyValueStorage()

internal class IosKeyValueStorage : KeyValueStorage {
    private val defaults = NSUserDefaults.standardUserDefaults

    override fun getString(key: String): String? = defaults.stringForKey(key)
    override fun putString(key: String, value: String) {
        defaults.setObject(value, forKey = key)
        defaults.synchronize()
    }
    override fun remove(key: String) {
        defaults.removeObjectForKey(key)
        defaults.synchronize()
    }
}
