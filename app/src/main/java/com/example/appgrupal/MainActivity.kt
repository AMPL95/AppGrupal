package com.example.appgrupal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import com.example.appgrupal.interfaces.psicoApi
import com.example.appgrupal.models.Psicologia
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }/*
    fun onLoad(){
    val retrofit = Retrofit.Builder()
        .baseUrl("") //poner url de nuestra api
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        val pokeapi = retrofit.create(psicoApi::class.java)

        val llamada = pokeapi.findDoctor("Louis")
}*/

}