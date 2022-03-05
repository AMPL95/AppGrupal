package com.example.appgrupal.APIejemplo

import com.google.gson.annotations.SerializedName

//clase utilzada para crear el objeto medicina y poder ampliar un nivel más el archivo JSON
data class Medicina(@SerializedName("nregistro")var id:String,
                    @SerializedName("nombre")var nombre:String,
                    @SerializedName("labtitular")var laboratorio:String,
                    @SerializedName("cpresc") var prescripcion:String,
                    @SerializedName("fotos") var fotos:List<Foto>?)