package com.example.appgrupal.APIejemplo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appgrupal.databinding.ItemmedicamentoBinding
import com.squareup.picasso.Picasso



/*
Este holder es el necesario para los recyclerview, aun no lo domino
 */
class MedicinaViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemmedicamentoBinding.bind(view)


    /* funcion que gracias al implements picasso del gradle consigue transformar una url (pasada por parametro
    como si fuera un String) en una imagen
     */
    fun bind(medicina:Medicina) {
        binding.tvNRegistro.setText("id: " + medicina.id)
        binding.tvNombre.setText(medicina.nombre)
        binding.tvLaboratorio.setText(medicina.laboratorio)
        binding.tvPrescripcion.setText(medicina.prescripcion)
        var foto : Foto? = medicina.fotos?.get(0)
        if(foto!=null) {
            Picasso.get().load(foto.url).into(binding.ivFoto)

        }
    }
}