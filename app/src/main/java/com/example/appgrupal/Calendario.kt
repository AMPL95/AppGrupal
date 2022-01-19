package com.example.appgrupal

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Calendario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)
        val textopedirCita: TextView = findViewById(R.id.etDate)

        textopedirCita.setOnClickListener{showDatePickerDialog() }

        }
    private fun showDatePickerDialog() {
        //datepickerfragment está en la carpeta ui
        //incializamos el calendario
        val datePicker = DatePickerFragment{day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day:Int, month: Int, year:Int){
        val textopedirCita: TextView = findViewById(R.id.etDate)
        textopedirCita.setText("has reservado tu cita el día $day de $month")
    }


}