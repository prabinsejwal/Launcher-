package com.example.launcheractivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val spinner: Spinner = findViewById(R.id.spinner)
        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)

        val cities = arrayOf("Toronto", "New York", "London")
        val temperatures = arrayOf("22°C", "25°C", "15°C")

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Update the displayed city temperature when the city is selected
                textView.text = "Select a city to see the temperature."
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        button.setOnClickListener {
            val position = spinner.selectedItemPosition
            // Display the temperature of the selected city
            textView.text = "Temperature in ${cities[position]}: ${temperatures[position]}"
        }
    }
}
