package com.example.savemylife.repository

import javax.inject.Inject


class AlertRepository(
    @Inject val alertService: AlertService
) {

    fun generateAlert() {
        // call alertService
    }
}