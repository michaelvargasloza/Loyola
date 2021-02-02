package com.example.loyola

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class Facultad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facultad)

        // access the items of the list
        val facultad = resources.getStringArray(R.array.Lista)

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
                            this@Facultad,
                            facultad[position], Toast.LENGTH_SHORT
                        ).show()
                    }

                    if (facultad[position] == "CIENCIAS ECONÓMICAS") {
                        var i = Intent(this@Facultad, CienciasEconomicas::class.java)
                        // To pass any data to next activity
                        //intent.putExtra("keyIdentifier", value)
                        // start your next activity
                        startActivity(i)
                    }

                    if (facultad[position] == "VER NOTAS") {
                        try {
                            Toast.makeText(this@Facultad, "Accediendo a notas1", Toast.LENGTH_SHORT).show()
                            val i = Intent(this@Facultad, WebViewNotas::class.java)
                            startActivity(i)
                            finish()
                        } catch (e: Exception) {
                            Toast.makeText(this@Facultad, "Error: $e", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }
}