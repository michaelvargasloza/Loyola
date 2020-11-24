package com.example.loyola

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast

class Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val lyt_admin = findViewById(R.id.btn_admin) as LinearLayout
        val lyt_comercial = findViewById(R.id.btn_com) as LinearLayout

        lyt_admin.setOnClickListener {
            Toast.makeText(this@Admin, "Administracion", Toast.LENGTH_SHORT).show()
        }

        lyt_comercial.setOnClickListener {
            Toast.makeText(this@Admin, "Comercial", Toast.LENGTH_SHORT).show()
        }
    }
}