package com.savemylife.repository

import com.savemylife.main.MainActivity
import com.savemylife.repository.service.AlertService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryModule {

    @Provides
    fun provideAlertService(): AlertService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://botmkd.atender.co/bot-mpm/services/")
            .build()
        return retrofit.create(AlertService::class.java)
    }

    @Provides
    fun provideAlertRepository(alertService: AlertService, settingsRepository: SettingsRepository): AlertRepository {
        return AlertRepository(alertService, settingsRepository)
    }

    @Provides
    fun provideSettingsRepository(activity: MainActivity): SettingsRepository {
        return SettingsRepository(activity)
    }
}