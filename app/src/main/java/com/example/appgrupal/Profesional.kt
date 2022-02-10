package com.example.appgrupal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appgrupal.APIejemplo.APIService
import com.example.appgrupal.APIejemplo.DogAdapter
import com.example.appgrupal.databinding.ActivityProfesionalBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Profesional : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityProfesionalBinding
    private lateinit var adapter: DogAdapter
    private var dogImages= mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfesionalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svDogs.setOnQueryTextListener(this)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    /*Instancia del retrofit. Al tener ":Retrofit" el objeto que se devuelve es de tipo retrofit.
    se pasa la url base, despues de la ultima / vendria la raza del perro que nos interese buscar.
    Siempre hay que fijarse en las instrucciones de las apis para saber cual es nuestra url base, ya que esa
    siempre será fija y lo siguiente lo añadiremos nosotros
     */
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    /* como la api deja seleccionar solo despues de "/breed/" pues a partir de ahi será donde pongamos nuestro
    objeto a buscar, que en este caso es una raza de perro. Pues esta funcion se le pasa por parametro el nombre
    de la raza y el CoroutineScope es para hacer multihilo, y que la busqueda sea fluida en lugar de que la app
    se detenga para buscar una raza en concreto
     */
    private fun searchByname(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            //utilizamos funciones de retrofit y las almacenamos en este objeto llamado call
            val call = getRetrofit().create(APIService::class.java).encuentraPorRaza("$query/images")
            val cachorro = call.body()

            //HILO PRINCIPAL QUE VE EL USUARIO
            runOnUiThread{
                /* si la call va bien pues dogImages que es una mutableList hara el metodo clear para limpiarse
                y addAll para añadir otra nueva lista a la lista dogImages, osea una lista dentro de otra lista. Paranoia
                y lo de las interrogaciones ya de locos... Es por si el nombre que metemos no da resultados pues la lista
                puede ser nula y dar como resultado una emptyList
                 */
                if (call.isSuccessful){
                    val images = cachorro?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
            }

        }
    }

    private fun showError() {
        Toast.makeText(this,"ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }


    /* estos 2 siguientes metodos se generan automaticamente al poner onquerytextListener arriba al comienzo de la
    clase. Es para cuando cambias algo en la barrita de busqueda pues el programa vaya buscando solo.
     */
    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            searchByname(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}