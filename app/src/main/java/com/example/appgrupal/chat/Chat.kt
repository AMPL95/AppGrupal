package com.example.appgrupal.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appgrupal.R
import com.example.appgrupal.chat.Constants.RECEIVE_ID
import com.example.appgrupal.chat.Constants.SEND_ID

import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.coroutines.*


class Chat : AppCompatActivity() {

    private lateinit var adapter: MessageAdapter
    private val botList = listOf("el Dr.Louis", "la Dra. Sara", "el Dr. Javier", "el Dr. Ángel")

    var messagesList = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        supportActionBar!!.setTitle("Pimentes")

        recyclerView()

        clickEvents()

        val random = (0..3).random()
        customBotMessage("Buenos días, usuario, soy ${botList[random]}, ¿Cómo puedo ayudarte?")
    }

    private fun clickEvents() {

        //envia el mensaje al pulsar el botón
        btn_send.setOnClickListener {
            sendMessage()
        }

        //desplaza el mensaje una posición hacia atras cuando se añade un nuevo mensaje
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    //inicio del recyclerView
    private fun recyclerView() {
        adapter = MessageAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //en caso de que haya mensajes, se desplazará el chat hasta el ultimo mensaje
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    //funcion para captar el mensaje enviado y si no es nulo llama a la funcion botResponse
    private fun sendMessage() {
        val message = et_message.text.toString()


        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(Message(message, SEND_ID))
            et_message.setText("")

            adapter.insertMessage(Message(message, SEND_ID))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    /*al llamar a esta función se le pasa el mensaje y como previamente en la clase BotResponses
    habíamos definido la funcion basiResponses se guarda el String que retorna ese metodo
     */
    private fun botResponse(message: String) {


        GlobalScope.launch {
            //efecto de espera de 1 segundo
            delay(1000)

            withContext(Dispatchers.Main) {
                //obtendo el String del método
                val response = BotResponses.basicResponses(message)

                //lo añado a la lista de mensajes como receive_id para saber donde colocarlo
                messagesList.add(Message(response, RECEIVE_ID))

                //inserto el mensaje en el adapter con este método definido en la clase MessageAdapter
                adapter.insertMessage(Message(response, RECEIVE_ID))

                //desplazo los mensajes una casilla para ver el nuevo
                rv_messages.scrollToPosition(adapter.itemCount - 1)



            }
        }
    }


    //función que utilizo en el onCreate para inicializar el chat con un mensaje recibido
    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {

                messagesList.add(Message(message, RECEIVE_ID))
                adapter.insertMessage(Message(message, RECEIVE_ID))

                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

}

