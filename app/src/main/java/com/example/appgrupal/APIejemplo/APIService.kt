package com.example.appgrupal.APIejemplo


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/* Esta es la interfaz que nos permite comunicarnos con la api. Con la etiqueta get damos la orden que se nos pide
en la mayoria de las apis. Ese get es para una función que va a devolver un objeto de tipo Response. La etiqueta
@url especifica que ese String será el utiliado como parametro para que la funcion se ejecute.

Como podemos ver, el objeto que se retorna es de tipo Respone pero que almacena en su interior la data class
previamente creada llamada MedicamentoResponse. Es como su fuera un arrayList de tipo <algo>

la palabra suspend esta puesta porque cuando llamo a esta funcion la tengo en un hilo diferente y es necesario
ponerlo, si no daría error, en la clase BuscadorMedcamentos esta comentado el hilo.
 */
interface APIService {
    @GET
    suspend fun encuentraPorMedicamento(@Url url:String): Response<MedicamentoResponse>
}