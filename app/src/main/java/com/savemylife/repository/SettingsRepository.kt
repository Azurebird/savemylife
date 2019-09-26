package com.savemylife.repository

import android.content.Context
import com.savemylife.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsRepository @Inject constructor(
    context: Context
) {

    private val sharedPref = context.getSharedPreferences(context.getString(R.string.settings_file), Context.MODE_PRIVATE)

    companion object {

        const val PHONE_NUMBER = "phone_number"
        const val CODE = "code"
        const val EMPTY = ""
    }

    fun saveSettings(phoneNumber: String, code: String) {
        with(sharedPref.edit()) {
            putString(PHONE_NUMBER, phoneNumber)
            putString(CODE, code)
            commit()
        }
    }

    fun getSetting(setting: String): String {
        return sharedPref.getString(setting, EMPTY) ?: EMPTY
    }
}