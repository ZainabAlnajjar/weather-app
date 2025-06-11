package com.izainab.myweatherapp.di

import com.izainab.myweatherapp.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { WeatherViewModel(get(), get()) }
}