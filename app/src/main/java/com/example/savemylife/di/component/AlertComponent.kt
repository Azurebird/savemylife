package com.example.savemylife.di.component

import com.example.savemylife.di.module.AlertModule
import com.example.savemylife.sensor.Accelerometer
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AlertModule::class))
interface AlertComponent {

    fun inject(accelerometer: Accelerometer)
}