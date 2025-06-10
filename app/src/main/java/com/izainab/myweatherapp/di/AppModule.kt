package com.izainab.myweatherapp.di

import com.izainab.myweatherapp.data.meteoAPIDataSource.WeatherRepositoryImp
import com.izainab.myweatherapp.domain.repositories.WeatherRepository
import com.izainab.myweatherapp.domain.services.LocationService
import com.izainab.myweatherapp.domain.useCases.GetCurrentLocationWeatherUseCase
import com.izainab.myweatherapp.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
//    viewModel { CounterViewModel() }
    single<WeatherRepository> { WeatherRepositoryImp() }

    single { LocationService() }

    single { GetCurrentLocationWeatherUseCase(get(), get()) }

    viewModel { WeatherViewModel(get()) }
}