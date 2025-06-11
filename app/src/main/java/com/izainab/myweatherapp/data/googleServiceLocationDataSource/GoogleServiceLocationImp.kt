package com.izainab.myweatherapp.data.googleServiceLocationDataSource

import android.Manifest
import android.location.Geocoder
import android.util.Log
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Tasks
import com.izainab.myweatherapp.domain.entities.Location
import com.izainab.myweatherapp.domain.exceptions.LocationFailureException
import com.izainab.myweatherapp.domain.services.LocationService

class GoogleServiceLocationImp(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val geocoder: Geocoder
) : LocationService {

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION])
    override suspend fun getCurrentLocation(): Location {
        return try {

            val location = Tasks.await(fusedLocationProviderClient.lastLocation)
            val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
            val address = addresses?.firstOrNull()?.getAddressLine(0)?.split(",")[2] ?: "Unknown"

            Log.i("Location : ", address.toString())
            location.let {
                Location(
                    latitude = it.latitude,
                    longitude = it.longitude,
                    city = address
                )
            }
        } catch (_: Exception) {
            throw LocationFailureException()
        }
    }
}
