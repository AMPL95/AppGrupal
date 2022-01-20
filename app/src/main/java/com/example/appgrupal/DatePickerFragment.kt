package com.example.appgrupal

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment(val listener: (day:Int, month:Int, Year:Int) -> Unit): DialogFragment(),//recibe una funcion con tres parametros (dia, mes y año) DialogFragment es una clase ya de android q nos fcilita la logica del dialogo
    DatePickerDialog.OnDateSetListener {


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog { //mostrar calendario en fecha actual
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH) //sumar 1 porque empieza a contar en 0
        val year = c.get(Calendar.YEAR)


        val picker = DatePickerDialog(activity as Context, this, year, month, day)
        picker.datePicker.minDate = c.timeInMillis  // día minimo para selccionar es hoy
        return picker
    }
}