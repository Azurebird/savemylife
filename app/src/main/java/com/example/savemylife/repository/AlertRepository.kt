package com.example.savemylife.repository

import com.example.savemylife.repository.service.AlertService
import javax.inject.Inject


class AlertRepository(
    @Inject val alertService: AlertService
) {

    fun generateAlert() {
        val xCoord = "6.2169826"
        val yCoord = "-75.5659104"
        val phone = "573164007939"
        val code = "784523"
        alertService.alert(xCoord, yCoord, phone, code)
    }
}