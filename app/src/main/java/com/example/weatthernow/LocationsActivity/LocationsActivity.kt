package com.example.weatthernow

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ListView
import android.widget.ArrayAdapter
import com.example.weatthernow.R

class LocationsActivity : AppCompatActivity() {

    private lateinit var addLocationButton: Button
    private lateinit var locationListView: ListView
    private val locations = arrayListOf("London", "New York", "Dubai")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locations)

        addLocationButton = findViewById(R.id.btn_add_location)
        locationListView = findViewById(R.id.location_list_view)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, locations)
        locationListView.adapter = adapter

        addLocationButton.setOnClickListener {
            val intent = Intent(this, AddLocationActivity::class.java)
            startActivity(intent)
        }
    }
}
