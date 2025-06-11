package com.izainab.myweatherapp

import android.app.Application
import com.izainab.myweatherapp.di.appModule
import com.izainab.myweatherapp.di.dataModule
import com.izainab.myweatherapp.di.domainModule
import com.izainab.myweatherapp.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidContext(this@WeatherApp)
            modules(appModule, dataModule, domainModule, uiModule)
        }
    }
}