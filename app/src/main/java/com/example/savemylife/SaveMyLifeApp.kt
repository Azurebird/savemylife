package com.example.savemylife

import com.example.savemylife.di.DaggerAlertComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class SaveMyLifeApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAlertComponent.create()
        appComponent.inject(this)
        return appComponent
    }
}