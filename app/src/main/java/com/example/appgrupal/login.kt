package com.example.appgrupal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.Theme_AppGrupal)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun onClickEntrar(view: View){
        val inicioIntent= Intent(this,Menu::class.java)
        startActivity(inicioIntent)
    }

    fun onClickRegistrar(view:View){
        val inicioIntent= Intent(this,RegistroPantalla::class.java)
        startActivity(inicioIntent)
    }


}