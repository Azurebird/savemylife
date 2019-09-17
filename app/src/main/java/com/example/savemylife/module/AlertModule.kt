package com.example.savemylife.module

import com.example.savemylife.repository.service.AlertService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AlertModule {

    @Provides
    fun provideAlertService(): AlertService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://botmkd.atender.co/bot-mpm/services")
            .build()
        return retrofit.create(AlertService::class.java)
    }
}