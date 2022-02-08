package com.example.appgrupal.APIejemplo

import com.google.gson.annotations.SerializedName

/* esta clase es necesaria porque se guardan los parametros que van a definir nuestra respuesta del servidor.
En este caso la respuesta es un status(que siempre esta) y una Lista de imagenes como Strings.

Si no se crea esta clase, la interfaz APIservice no funcionaria ya que hay que pasarle esta data class como
parametro.

los @ son para decir especificiamente los objetos que se recuperan de la api en internet, de no poner los @
las variables deben llamarse identicamente a los objetos que se nos da en la api. De esta manera es mas intuitivo
que el objeto menssage recuperado de la api lo llamemos como "var images", ya que en realidad son archivos .jpg
pero recuperados como String
 */

data class DogResponse(@SerializedName ("Status")var status:String,
                       @SerializedName ("message") var images:List<String>)
