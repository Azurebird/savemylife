package com.example.savemylife.di.module

import com.example.savemylife.repository.AlertRepository
import com.example.savemylife.repository.service.AlertService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AlertModule {

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
}