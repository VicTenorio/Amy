package com.example.idosplashscreen.Model

import com.beust.klaxon.JsonObject
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import org.json.JSONObject
import java.io.StringReader
import java.util.*


data class Service( var id: Int
                   ,var idUsuario: Int
                   ,var endereco: Endereco
                   ,var idCategoria: Int
                   ,var imagem: ArrayList<Imagem>
                   ,var nome: String
                   ,var descricao: String
                   ,var tempoExecucao: String
                   ,var preco: Double
                   ,var localizacaoFixa: Boolean){

    constructor():this(
        0,
        0,
         Endereco(),
        0,
         arrayListOf(),
        "",
        "",
        "",
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


    fun streamingJson(jsonString: String?) : Service {

        var jsonObject = JSONObject(jsonString)

        var endereco = Endereco(
        )

        var service = Service(
            jsonObject.getInt("id"),
            jsonObject.getInt("idUsuario"),
            endereco,
            jsonObject.getInt("idCategoria"),
            imagem,//arrayListOf(),
            jsonObject.getString("nome"),
            jsonObject.getString("descricao"),
            jsonObject.getString("tempoExecucao"),
            jsonObject.getDouble("preco"),
            jsonObject.getBoolean("localizacaoFixa")
        )

        return service
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