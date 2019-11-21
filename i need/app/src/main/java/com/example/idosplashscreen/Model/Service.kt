package com.example.idosplashscreen.Model

import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import java.io.StringReader
import java.util.*


data class Service( val id: Int
                   ,val idUsuario: Int
                   ,val endereco: Endereco
                   ,val idCategoria: Int
                   ,val imagem: String
                   ,val nome: String
                   ,val descricao: String
                   ,val tempoExecucao: Date?
                   ,val preco: Double
                   ,val localizacaoFixa: Boolean){

    constructor():this(
        0,
        0,
         Endereco(),
        0,
        "",
        "",
        "",
        null,
        0.0,
        false
    )

    fun toJson() : String{
        return("""{"idUsuario" : "${this.idUsuario}",
            "endereco" : ${this.endereco.toJson()},
            "idCatedogia" : "${this.idCategoria}",
            "imagem" : "${this.imagem}",
            "nome" : "${this.nome}",
            "descricao" : "${this.descricao}",
            "tempoExecucao" : "${this.tempoExecucao}",
            "preco" : "${this.preco}",
            "localizacaoFixa" : "${this.localizacaoFixa}"}""")

    }



    fun streamingArray(array:String):ArrayList<Service> {
        val klaxon = Klaxon()
        JsonReader(StringReader(array)).use { reader ->
            val result = arrayListOf<Service>()
            reader.beginArray {
                while (reader.hasNext()) {
                    val service = klaxon.parse<Service>(reader)
                    if (service != null) {
                        result.add(service)
                    }

                }
            }
            return result
        }
    }
}