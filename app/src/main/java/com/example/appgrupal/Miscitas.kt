package com.example.appgrupal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_miscitas.*

class Miscitas : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_miscitas)

        val miboton: Button = findViewById(R.id.buttonRecuperar)
        miboton.setOnClickListener{

            db.collection("citas").document(textdni2.text.toString()).get().addOnSuccessListener {
                recuperarcita.setText(it.get("datoscita") as String?)
                recuperarhora.setText(it.get("hora")as String?)
                recuperardoctor.setText(it.get("especialista")as String?)
            }


        }
    }

    fun onClickAtras(view: View){
        val inicioIntent= Intent(this,Menu::class.java)
        startActivity(inicioIntent)
    }
}