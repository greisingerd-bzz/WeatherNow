package com.example.weatthernow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.weatthernow.R

class AddLocationActivity : AppCompatActivity() {

    private lateinit var locationInput: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_location)

        locationInput = findViewById(R.id.et_location_input)
        addButton = findViewById(R.id.btn_add)

        addButton.setOnClickListener {
            val newLocation = locationInput.text.toString()
            if (newLocation.isNotEmpty()) {
                // Hier wird die Logik implementiert, um den Standort zu speichern
                Toast.makeText(this, "$newLocation hinzugefügt", Toast.LENGTH_SHORT).show()
                finish() // Zurück zum Locations Screen
            } else {
                Toast.makeText(this, "Bitte einen gültigen Standort eingeben", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
