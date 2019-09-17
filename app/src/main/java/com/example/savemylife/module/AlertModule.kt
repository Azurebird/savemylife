package com.example.savemylife.module

import com.example.savemylife.repository.AlertService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object AlertModule {

    @Provides
    fun provideAlertService(): AlertService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://botmkd.atender.co/")
            .build()
        return retrofit.create(AlertService::class.java)
    }
}