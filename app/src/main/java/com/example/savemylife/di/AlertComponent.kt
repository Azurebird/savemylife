package com.example.savemylife.di

import com.example.savemylife.main.MainActivity
import com.example.savemylife.main.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    ActivityBuilder::class))
interface AlertComponent: AndroidInjector<DaggerApplication>