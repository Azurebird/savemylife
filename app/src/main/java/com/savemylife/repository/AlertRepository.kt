package com.savemylife.repository

import android.util.Log
import com.savemylife.repository.service.AlertService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class AlertRepository @Inject constructor(
    var alertService: AlertService,
    var settingsRepository: SettingsRepository
) {

    fun generateAlert() {
        val xCoord = "6.2169826"
        val yCoord = "-75.5659104"
        val phone = settingsRepository.getSetting(SettingsRepository.PHONE_NUMBER)
        val code = settingsRepository.getSetting(SettingsRepository.CODE)
        Log.i("Tag", "Sending to ${phone} with code ${code}")
        alertService.alert(xCoord, yCoord, phone, code).enqueue(EmptyCallBack())
    }
}

class EmptyCallBack: Callback<Void> {
    override fun onFailure(call: Call<Void>, t: Throwable) {
        Log.e("Tag", "Error", t)
    }
    override fun onResponse(call: Call<Void>, response: Response<Void>) {
        Log.e("Tag", "Worked!")
    }
}