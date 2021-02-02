package com.example.loyola

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewNotas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_notas)

        cargarPagina()
    }

    fun cargarPagina(){
        try {
            val myWebView: WebView = findViewById(R.id.webPantalla)
            //Habilita Javascript en el navegador
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.getSettings().setDomStorageEnabled(true);
            //Evita que los enlaces redireccionen al navegador
            myWebView.setWebViewClient(WebViewClient())
            myWebView.loadUrl("http://www.loyola.edu.bo/portal/index.php")
        } catch (e: Exception){
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setMessage("Ocurrió un problema al momento de conectar con el servidor, espere un momento por favor.")
            builder.setPositiveButton(
                "Aceptar"
            ) { dialog, id -> finish() }
            builder.create()
            builder.show()
        }
    }

    override fun onBackPressed() {
        val myWebView: WebView = findViewById(R.id.webPantalla)

        if (myWebView != null && myWebView.canGoBack()) {
            myWebView.goBack()
        } // if there is previous page open it
        else {
            AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Salir")
                .setMessage("¿Desea salir de la aplicación?")
                .setPositiveButton("Si") {
                        dialog, which -> finish()
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
}