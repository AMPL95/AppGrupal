package com.example.appgrupal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.appgrupal.Videollamada.VideoLLamada
import com.example.appgrupal.chat.Chat

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)



    }

    fun onClickPedirCita(view: View){
        val inicioIntent= Intent(this,Calendario::class.java)
        startActivity(inicioIntent)
    }
    fun onClickentrarChat(view: View){
        val inicioIntent= Intent(this, Chat::class.java)
        startActivity(inicioIntent)
    }
    fun onClickMisCitas(view: View){
        val inicioIntent= Intent(this, Miscitas::class.java)
        startActivity(inicioIntent)
    }

    fun onClickInformes(view: View){
        val inicioIntent= Intent(this, informes::class.java)
        startActivity(inicioIntent)
    }

    fun onClickProfesional(view: View){
        val inicioIntent= Intent(this, BuscadorMedicamentos::class.java)
        startActivity(inicioIntent)
    }

    fun onClickVideollamada() {
        val inicioIntent= Intent(this, VideoLLamada::class.java)
        startActivity(inicioIntent)
    }




}