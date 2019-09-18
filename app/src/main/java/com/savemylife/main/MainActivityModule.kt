package com.savemylife.main

import android.content.Context
import android.hardware.SensorManager
import com.savemylife.repository.AlertRepository
import com.savemylife.repository.service.AlertService
import com.savemylife.sensor.Accelerometer
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainActivityModule {

    @Provides
    fun provideAlertService(): AlertService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://botmkd.atender.co/bot-mpm/services/")
            .build()
        return retrofit.create(AlertService::class.java)
    }

    @Provides
    fun provideAlertRepository(alertService: AlertService): AlertRepository {
        return AlertRepository(alertService)
    }

    @Provides
    fun provideSensorService(activity: MainActivity): SensorManager {
        return activity.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    @Provides
    fun provideAccelerometer(sensorManager: SensorManager, alertRepository: AlertRepository): Accelerometer {
        return Accelerometer(sensorManager, alertRepository)
    }
}