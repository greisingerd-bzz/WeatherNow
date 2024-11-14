package com.example.weatthernow.network

import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class WeatherService {

    private val client = OkHttpClient()
    private val apiKey = "DEIN_API_KEY_HIER" // Ersetze mit deinem API-Schlüssel
    private val baseUrl = "https://api.openweathermap.org/data/2.5/weather"

    fun getCurrentWeather(city: String, callback: (String) -> Unit) {
        val url = "$baseUrl?q=$city&appid=$apiKey&units=metric&lang=de"

        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                callback("Fehler beim Abrufen der Wetterdaten")
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) {
                        callback("Fehler: ${response.code}")
                        return
                    }

                    val responseData = response.body?.string()
                    if (responseData != null) {
                        val jsonObject = JSONObject(responseData)
                        val weatherDescription = jsonObject.getJSONArray("weather")
                            .getJSONObject(0).getString("description")
                        val temperature = jsonObject.getJSONObject("main")
                            .getDouble("temp")
                        callback("Wetter: $weatherDescription, Temperatur: $temperature°C")
                    } else {
                        callback("Keine Wetterdaten verfügbar")
                    }
                }
            }
        })
    }
}
