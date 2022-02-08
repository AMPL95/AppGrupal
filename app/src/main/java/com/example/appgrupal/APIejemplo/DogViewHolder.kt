package com.example.appgrupal.APIejemplo

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.appgrupal.databinding.ItemdogBinding
import com.squareup.picasso.Picasso


/*
Este holder es el necesario para los recyclerview, aun no lo domino
 */
class DogViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemdogBinding.bind(view)


    /* funcion que gracias al implements picasso del gradle consigue transformar una url (pasada por parametro
    como si fuera un String) en una imagen
     */
    fun bind(image:String){
        Picasso.get().load(image).into(binding.ivDog)


    }
}