package com.example.appgrupal.APIejemplo

import com.google.gson.annotations.SerializedName

/* esta clase es necesaria porque se guardan los parametros que van a definir nuestra respuesta del servidor.


Si no se crea esta clase, la interfaz APIservice no funcionaria ya que hay que pasarle esta data class como
parametro.

los @ son para decir especificiamente los objetos que se recuperan de la api en internet, de no poner los @
las variables deben llamarse identicamente a los objetos que se nos proporciona la api.
 */

data class MedicamentoResponse(@SerializedName("totalFilas")var totalFilas:Int,
                               @SerializedName("pagina")var pagina:Int,
                               @SerializedName("tamanioPagina")var tamanioPagina:Int,
                               @SerializedName("resultados") var variedades:List<Medicina>)