package com.izainab.myweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.izainab.myweatherapp.presentation.screens.MainScreen
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            MyWeatherAppTheme {
//            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                MainScreen(modifier = Modifier.padding(innerPadding))
//            }
//            }
            MainScreen()
//
        }
    }
}