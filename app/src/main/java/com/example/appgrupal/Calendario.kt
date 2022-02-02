package com.example.appgrupal

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_calendario.*


class Calendario : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
        etDate.setOnClickListener{ showDatePickerDialog() }


        val miboton: Button = findViewById(R.id.bconfirmar)
        miboton.setOnClickListener{

            db.collection("citas").document(etDate.text.toString()).set(
                hashMapOf("datoscita" to etDate.text.toString(),
                )
            )

            val myToast = Toast.makeText(applicationContext, "cita confirmada", Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.LEFT, 200, 200)
            myToast.show()

        }


        }


    private fun showDatePickerDialog() {
        //incializamos el calendario
        val datePicker = DatePickerFragment{day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day:Int, month: Int, year:Int){
        val textopedirCita: TextView = findViewById(R.id.etDate)
        val suma1 = month +1
        textopedirCita.setText("Cita día $day de $suma1")
    }
    fun onClickAtras(view: View){
        val inicioIntent= Intent(this,Menu::class.java)
        startActivity(inicioIntent)
    }

}