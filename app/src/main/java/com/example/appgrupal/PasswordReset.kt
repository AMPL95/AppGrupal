package com.example.appgrupal

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.reset_password.*



class PasswordReset : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    /*private val db = FirebaseFirestore.getInstance()*/
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reset_password)
        mAuth = FirebaseAuth.getInstance()

        supportActionBar!!.setTitle("Pimentes")

       botonReset.setOnClickListener {
            val email = emailReset.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "Enter your email!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth!!.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@PasswordReset, "Check email to reset your password!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@PasswordReset, "Fail to send reset password email!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
        //Para los email que no tenemos guardado esta opción te da la contraseña que se había puesto anteriormente
       /* val miboton: Button = findViewById(R.id.botonReset)
        miboton.setOnClickListener{

            db.collection("clientes").document(emailReset.text.toString()).get().addOnSuccessListener {
                recuperarpassw.setText(it.get("Passwd") as String?)


            }
        }*/
    }

}