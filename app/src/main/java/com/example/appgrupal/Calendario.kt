package com.example.appgrupal

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_calendario.*


class Calendario : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
        etDate.setOnClickListener{ showDatePickerDialog() }

        //spinner hora
        val spinner = findViewById<Spinner>(R.id.spnElementos)

        val lista = listOf("10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","17:00","17:30","18:00","18:30","19:00","19:30","20:00")

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador

        //spinner doctor

        val spinner2 = findViewById<Spinner>(R.id.spnDoctores)

        val lista2 = listOf("Doctor Louis","Doctor Javier","Doctora Sara","Doctor Ángel")

        val adaptador2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista2)
        spinner2.adapter = adaptador2



        val miboton: Button = findViewById(R.id.bconfirmar)
        miboton.setOnClickListener{

            db.collection("citas").document(textDNI.text.toString()).set(
                hashMapOf("datoscita" to etDate.text.toString(),
                    "hora" to spnElementos.selectedItem.toString(),
                    "especialista" to spnDoctores.selectedItem.toString())
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
        textopedirCita.setText("Día $day de $suma1")
    }
    fun onClickAtras(view: View){
        val inicioIntent= Intent(this,Menu::class.java)
        startActivity(inicioIntent)
    }

}