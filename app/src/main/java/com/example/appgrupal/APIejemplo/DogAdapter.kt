package com.example.appgrupal.APIejemplo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appgrupal.R

/*La clase adapter es una clase necesaria para utilizar los recyclerview, que son las vistas como las del chat
Aun no las se dominar
 */

class DogAdapter(val images:List<String>):RecyclerView.Adapter<DogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.itemdog,parent,false))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
       return images.size
    }
}