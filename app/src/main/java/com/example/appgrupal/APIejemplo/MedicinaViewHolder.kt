package com.example.appgrupal.APIejemplo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appgrupal.databinding.ItemmedicamentoBinding
import com.squareup.picasso.Picasso



/*
Este holder es el necesario para hacer uso del recyclerView.
 */
class MedicinaViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemmedicamentoBinding.bind(view)


    /* función que asignará al xml que contiene nuestro objeto que queremos visualizar todos aquellos
    valore que obtengamos de la api

    Gracias al implements picasso del gradle consigue transformar una url (pasada por parametro
    como si fuera un String) en una imagen

    COMO EN LA API HAY MEDICAMENTOS QUE NO TIENEN FOTO Y PARA EVITAR LOS ERRORES NULL LO INCLUYO DENTRO
    DE UN IF ANTES DE TRANSFORMAR LA URL EN UNA IMAGEN.
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