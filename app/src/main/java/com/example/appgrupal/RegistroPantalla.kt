package com.example.appgrupal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RegistroPantalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_pantalla)
    }

    fun onClickPedirCita(view: View){
        val inicioIntent= Intent(this,Calendario::class.java)
        startActivity(inicioIntent)
    }
}