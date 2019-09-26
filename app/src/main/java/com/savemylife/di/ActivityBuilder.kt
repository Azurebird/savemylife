package com.savemylife.di

import com.savemylife.main.MainActivity
import com.savemylife.main.MainActivityModule
import com.savemylife.repository.RepositoryModule
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder: AndroidInjector<MainActivity> {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class, RepositoryModule::class))
    abstract fun bindMainActivity(): MainActivity
}