package com.example.loyola

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val DURACION_SPLASH = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!verificaConexion(this)) {
            sinConexion()
        } else {
            conectado()
        }
    }

    fun verificaConexion(ctx: Context): Boolean {
        var bConectado = false
        val connec = ctx
            .getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val redes = connec.allNetworkInfo
        for (i in 0..1) {
            if (redes[i].state == NetworkInfo.State.CONNECTED) {
                bConectado = true
            }
        }
        return bConectado
    }

    fun sinConexion() {
        try {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setMessage("No se ha podido conectar con el servidor, verifique su conexión a internet.")
            builder.setPositiveButton(
                "Aceptar"
            ) { dialog, id -> finish() }
            builder.create()
            builder.show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error: $e", Toast.LENGTH_SHORT).show()
        }
    }

    fun conectado() {
        try {
            Handler().postDelayed({
                val i = Intent(this@MainActivity, Facultad::class.java)
                startActivity(i)
                finish()
            }, DURACION_SPLASH.toLong())
        } catch (e: Exception) {
            Toast.makeText(this, "Error: $e", Toast.LENGTH_SHORT).show()
        }
    }
}