package com.example.appgrupal.chat


import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotResponses {

    // función que retorna el string el que el bot va a responder
    fun basicResponses(_message: String): String {


        val random = (0..2).random()
        val message = _message.lowercase(Locale.getDefault())
        var empty = ""

        //when es lo mismo que un switch case
        return when {

            /*si el mensaje que pasamos por parametro a la funcion no esta vacio. No hará caso
                a ninguno de los otros casos.*/
            message.isNotEmpty() ->{

                "Respuesta del bot"

            }



            //si el mensaje contiene hola hara una de estas opciones
            message.contains("hola") -> {
                when (random) {
                    0 -> "Hola que tal???"
                    1 -> "Buenas tardes"
                    2 -> "Hola como estas?"
                    else -> "error" }
            }

            //si el mensaje contiene esta frase hara una de estas opciones
            message.contains("bien y tu?") -> {
                when (random) {
                    0 -> "Lo llevo bien"
                    1 -> "tengo sueño"
                    2 -> "Pues aqui adamios"
                    else -> "error"
                }
            }


            message.contains("hora") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }


            //default del switch case para cuando no se de una respuesta adecuada
            else -> {
                when (random) {
                    0 -> "no te he entendido"
                    1 -> "Pruba a preguntarme otra cosa"
                    2 -> "No sé"
                    else -> "error"
                }
            }
        }
    }
}