package com.example.startup_mobile.platform

interface KeyValueStorage {
    fun getString(key: String): String?
    fun putString(key: String, value: String)
    fun remove(key: String)
}

expect fun getKeyValueStorage(): KeyValueStorage
