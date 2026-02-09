package com.example.startup_mobile.platform

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

private const val PREFS_NAME = "startup_mobile_prefs"

@SuppressLint("StaticFieldLeak")
internal object AndroidStorageHolder {
    var context: Context? = null
}

/** Вызвать из Application или MainActivity для инициализации хранилища. */
fun initKeyValueStorage(context: Context) {
    AndroidStorageHolder.context = context.applicationContext
}

actual fun getKeyValueStorage(): KeyValueStorage = AndroidKeyValueStorage()

internal class AndroidKeyValueStorage : KeyValueStorage {
    private val prefs: SharedPreferences?
        get() = AndroidStorageHolder.context?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun getString(key: String): String? = prefs?.getString(key, null)
    override fun putString(key: String, value: String) {
        prefs?.edit()?.putString(key, value)?.apply()
    }

    override fun remove(key: String) {
        prefs?.edit()?.remove(key)?.apply()
    }
}
