package com.example.appgrupal.APIejemplo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appgrupal.R

/*La clase adapter es una clase necesaria para utilizar los recyclerview, que son las vistas como las del chat
Aun no las se dominar
 */

class MedicinaAdapter(val medicinas:List<Medicina>): RecyclerView.Adapter<MedicinaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicinaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MedicinaViewHolder(layoutInflater.inflate(R.layout.itemmedicamento,parent,false))
    }

    override fun onBindViewHolder(holder: MedicinaViewHolder, position: Int) {
        val item = medicinas[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return medicinas.size
    }
}