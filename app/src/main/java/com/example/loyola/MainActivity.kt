package com.example.loyola

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000);
        setTheme(R.style.Loyola)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // access the items of the list
        val facultad = resources.getStringArray(R.array.Languages)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, facultad)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    if (facultad[position] == "SELECCIONE LA FACULTAD") {
                        Toast.makeText(
                            this@MainActivity,
                            facultad[position], Toast.LENGTH_SHORT
                        ).show()
                    }

                    if (facultad[position] == "CIENCIAS ECONÓMICAS") {
                        var i = Intent(this@MainActivity, Admin::class.java)
                        // To pass any data to next activity
                        //intent.putExtra("keyIdentifier", value)
                        // start your next activity
                        startActivity(i)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
}