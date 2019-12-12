package com.example.idosplashscreen.Model

import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import java.io.StringReader
import java.util.ArrayList

data class Contrato(val valorFinal:Double,
                    val pago:Boolean,
                    val prestador:ArrayList<Usuario>){

    constructor():this(0.0,true, arrayListOf())

    fun streamingArray(array:String): ArrayList<Contrato> {
        val klaxon = Klaxon()
        JsonReader(StringReader(array)).use { reader ->
            val result = arrayListOf<Contrato>()
            reader.beginArray {
                while (reader.hasNext()) {
                    val service = klaxon.parse<Contrato>(reader)
                    if (service != null) {
                        result.add(service)
                    }

                }
            }
            return result
        }
    }
}