package com.izainab.myweatherapp.di

import com.izainab.myweatherapp.domain.useCases.GetWeatherByLocationUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetWeatherByLocationUseCase(get()) }
}