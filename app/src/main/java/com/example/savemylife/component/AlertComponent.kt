package com.example.savemylife.component

import com.example.savemylife.module.AlertModule
import com.example.savemylife.repository.AlertRepository
import com.example.savemylife.sensor.Accelerometer
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AlertModule::class))
interface AlertComponent {
    fun inject(accelerometer: Accelerometer)
    fun inject(alertRepository: AlertRepository)
}