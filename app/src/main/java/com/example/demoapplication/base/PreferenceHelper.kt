package com.glowdubai_staff.base

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.preference.PreferenceManager
import com.example.demoapplication.service.MyApplication.Companion.context
import com.example.demoapplication.utills.AppConstants
import com.google.gson.Gson


object PreferenceHelper {

    lateinit var myPref: SharedPreferences

    fun init(context: Context) {
        myPref = context.customPrefs()
    }

    fun defaultPrefs(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    fun Context.customPrefs(): SharedPreferences {
        return getSharedPreferences("AppPref", Context.MODE_PRIVATE)
    }

    private  fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }


    /**
     * puts a key value pair in shared prefs if doesn't exists, otherwise updates value on given [key]
     */
    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    /**
     * finds value on given key.
     * [T] is the type of value
     * @param defaultValue optional default value - will take null for strings, false for bool and -1 for numeric values if [defaultValue] is not specified
     */
    inline operator fun <reified T : Any> SharedPreferences.get(
        key: String,
        defaultValue: T? = null,
    ): T? {
        return when (T::class) {
            String::class -> getString(key, defaultValue as? String) as T?
            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }

    /**
    remove preference
     */
    fun removePreference(key: String) {
        val preferences = context.customPrefs()
        val editor = preferences.edit()
        editor.remove(key)
        editor.apply()
    }

    fun SharedPreferences.clear(context: Context) {
        val preferences = context.customPrefs()
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }

    fun saveObject(key: String, value: Any?) {
        myPref[key] = Gson().toJson(value)
    }

    fun <T : Any> getObject(key: String, className: Class<T>): T {
        return Gson().fromJson(myPref[key, ""], className)
    }

    fun clear(context: Context) {
        val preferences = context.customPrefs()
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }



    fun SharedPreferences.getLanguge(): String {
        return getString(AppConstants.PREFERECENCE_UTILLS.LANGUAGE, "")!!
    }

    fun SharedPreferences.getUserName(): String {
        return getString(AppConstants.PREFERECENCE_UTILLS.USER_NAME, "")!!
    }


}