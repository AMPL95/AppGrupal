package com.example.appgrupal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_plan_de_pago.*

class PlanDePago : AppCompatActivity() {

    var sampleImages = intArrayOf(
        R.drawable.planfree,
        R.drawable.planstandart,
        R.drawable.planpremium

    )

    var planesdepago = arrayOf(
        "ha seleccionado plan free",
        "ha seleccionado plan standart",
        "ha seleccionado plan premium"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_de_pago)

        supportActionBar!!.setTitle("Pimentes")

        carrousel.pageCount = planesdepago.size

        carrousel.setImageListener { position, imageView ->
            imageView.setImageResource(sampleImages[position])
        }
        carrousel.setImageClickListener {position ->
            Toast.makeText(applicationContext, planesdepago[position], Toast.LENGTH_SHORT).show()
            val inicioIntent= Intent(this,login::class.java)
            startActivity(inicioIntent)
        }


    }

    fun onClickAtras(view: View){
        val inicioIntent= Intent(this,login::class.java)
        startActivity(inicioIntent)
    }

    fun clickenimagen(view: View){
        val inicioIntent= Intent(this,login::class.java)
        startActivity(inicioIntent)
    }
}