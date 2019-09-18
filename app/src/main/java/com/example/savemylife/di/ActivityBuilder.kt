package com.example.savemylife.di

import com.example.savemylife.main.MainActivity
import com.example.savemylife.main.MainActivityModule
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder: AndroidInjector<MainActivity> {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}