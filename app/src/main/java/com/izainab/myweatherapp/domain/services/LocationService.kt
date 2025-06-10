package com.izainab.myweatherapp.domain.services

import com.izainab.myweatherapp.domain.entities.Location

class LocationService {

    suspend fun getCurrentLocation(): Location {

        //TODO: implement this

        return Location(latitude = 52.52, longitude = 13.41, city = "Basra")
    }
}