package com.savemylife.main

import android.content.Context
import android.hardware.SensorManager
import com.savemylife.repository.AlertRepository
import com.savemylife.repository.SettingsRepository
import com.savemylife.repository.service.AlertService
import com.savemylife.sensor.Accelerometer
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainActivityModule {

    @Provides
    fun provideSensorService(activity: MainActivity): SensorManager {
        return activity.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    @Provides
    fun provideAccelerometer(sensorManager: SensorManager, alertRepository: AlertRepository): Accelerometer {
        return Accelerometer(sensorManager, alertRepository)
    }
}