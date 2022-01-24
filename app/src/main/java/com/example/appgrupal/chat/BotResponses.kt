package com.example.appgrupal.chat


import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotResponses {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message = _message.lowercase(Locale.getDefault())
        var empty = ""

        return when {

            message.isNotEmpty() ->{

                "Respuesta del bot"

            }


            //Hello
            message.contains("hola") -> {
                when (random) {
                    0 -> "Hola que tal???"
                    1 -> "Buenas tardes"
                    2 -> "Hola como estas?"
                    else -> "error" }
            }

            //How are you?
            message.contains("bien y tu?") -> {
                when (random) {
                    0 -> "Lo llevo bien"
                    1 -> "tengo sueño"
                    2 -> "Pues aqui adamios"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }


            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}