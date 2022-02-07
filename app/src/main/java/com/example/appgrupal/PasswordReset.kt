package com.example.appgrupal

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.reset_password.*

class PasswordReset : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reset_password)

        val miboton: Button = findViewById(R.id.botonReset)
        miboton.setOnClickListener{

            db.collection("clientes").document(emailReset.text.toString()).get().addOnSuccessListener {
                recuperarpassw.setText(it.get("Passwd") as String?)
            }
        }
    }

}