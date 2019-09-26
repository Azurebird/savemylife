package com.savemylife.repository

import android.content.Context
import com.savemylife.R
import javax.inject.Inject

class SettingsRepository @Inject constructor(
    var context: Context
) {

    fun saveSettings(phoneNumber: String, code: String) {
        val sharedPref = context.getSharedPreferences(context.getString(R.string.settings_file), Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString(context.getString(com.savemylife.R.string.property_phone_number), phoneNumber)
            putString(context.getString(com.savemylife.R.string.code), code)
            commit()
        }
    }
}