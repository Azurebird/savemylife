package com.example.savemylife.repository

import android.util.Log
import com.example.savemylife.repository.service.AlertService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class AlertRepository(
    @Inject @JvmField var alertService: AlertService
) {

    fun generateAlert() {
        val xCoord = "6.2169826"
        val yCoord = "-75.5659104"
        val phone = "573164007939"
        val code = "784523"
        alertService.alert(xCoord, yCoord, phone, code).enqueue(object: Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("Tag", "Error", t)
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Log.e("Tag", "Worked!")
            }
        })
    }
}