package com.example.weatthernow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.weatthernow.R

class ForecastActivity : AppCompatActivity() {

    private lateinit var forecastTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        forecastTextView = findViewById(R.id.forecast_text_view)

        // Beispielcode für Vorhersage (dieser Teil benötigt noch die Implementierung des WeatherService)
        forecastTextView.text = "Vorhersage für die nächsten 5 Tage wird geladen..."
    }
}
