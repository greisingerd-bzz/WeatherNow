package com.example.weathernow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.weatthernow.ForecastActivity
import com.example.weatthernow.LocationsActivity
import com.example.weatthernow.R
import com.example.weatthernow.WeatherNotificationHelper
import com.example.weatthernow.network.WeatherService

class MainActivity : AppCompatActivity() {

    private lateinit var weatherTextView: TextView
    private lateinit var locationButton: Button
    private lateinit var forecastButton: Button
    private lateinit var notificationHelper: WeatherNotificationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherTextView = findViewById(R.id.weather_text_view)
        locationButton = findViewById(R.id.btn_location)
        forecastButton = findViewById(R.id.btn_forecast)
        notificationHelper = WeatherNotificationHelper(this)

        // Initial Weather Load
        loadWeatherData()

        // Navigate to Locations Screen
        locationButton.setOnClickListener {
            val intent = Intent(this, LocationsActivity::class.java)
            startActivity(intent)
        }

        // Navigate to Forecast Screen
        forecastButton.setOnClickListener {
            val intent = Intent(this, ForecastActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadWeatherData() {
        val weatherService = WeatherService()
        weatherService.getCurrentWeather("Zürich") { weatherInfo ->
            runOnUiThread {
                weatherTextView.text = weatherInfo
                // Beispiel für Wetterwarnung
                if (weatherInfo.contains("starkem Regen") || weatherInfo.contains("Sturm")) {
                    notificationHelper.sendWeatherAlertNotification(
                        "Wetterwarnung",
                        "Achtung! $weatherInfo"
                    )
                }
            }
        }
    }
}
