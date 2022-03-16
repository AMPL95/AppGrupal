package com.example.appgrupal.APIejemplo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appgrupal.R

/*La clase adapter es una clase necesaria para utilizar los recyclerview, que son las vistas como las del chat,
como si fueran bloques de diseño que se repiten. Recibe por parametro una lista de objetos de aquello que
vamos a representar

Consta de 3 funciones obligadas de implementar. La primera de ellas sirve para mostrar la vista en aquella
pantalla que nos interesa y para obtener el item que queramos mostrar.

la segunda funcion hace uso del item que queremos mostrar y un numero entero que referencirá la posición
en la que mostrar el item y por ultimo lo muestra con .bind

la 3a función retorna la longitud de la lista para mostrar las posiciones exactas
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