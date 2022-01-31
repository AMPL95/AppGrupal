package com.example.appgrupal.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appgrupal.R
import com.example.appgrupal.chat.Constants.RECEIVE_ID
import com.example.appgrupal.chat.Constants.SEND_ID
/*import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.coroutines.*


class Chat : AppCompatActivity() {

    private lateinit var adapter: MessageAdapter
    private val botList = listOf("el Dr.Louis", "la Dra. Sara", "el Dr. Javier", "el Dr. Ángel")

    var messagesList = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerView()

        clickEvents()

        val random = (0..3).random()
        customBotMessage("Buenos días, usuario, soy ${botList[random]}, ¿Cómo puedo ayudarte?")
    }

    private fun clickEvents() {

        //Send a message
        btn_send.setOnClickListener {
            sendMessage()
        }

        //Scroll back to correct position when user clicks on text view
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MessageAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

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

    private fun botResponse(message: String) {


        GlobalScope.launch {
            //Fake response delay
            delay(1000)

            withContext(Dispatchers.Main) {
                //Gets the response
                val response = BotResponses.basicResponses(message)

                //Adds it to our local list
                messagesList.add(Message(response, RECEIVE_ID))

                //Inserts our message into the adapter
                adapter.insertMessage(Message(response, RECEIVE_ID))

                //Scrolls us to the position of the latest message
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                //Starts Google

            }
        }
    }

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

}*/