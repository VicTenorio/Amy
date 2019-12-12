package com.example.idosplashscreen.Model

import com.example.idosplashscreen.Model.Endereco
import org.json.JSONObject

data class Usuario (var id_usuario: Int,
                    var rg: String,
                    var cpf_cnpj: String,
                    var data_nascimento: String,
                    var email: String,
                    var estado_civil: String,
                    var nome: String,
                    var prestador: Boolean,
                    var senha: String,
                    var sexo: String,
                    var telefone: String,
                    var endereco: Endereco
){
    constructor():this(0,
        "",
        "",
        "",
        "",
        "",
        "",
        false,
        "",
        "",
        "",
        Endereco()
    )

    //usar ${this.endereco.toJson()} no endereço
    fun toJson() : String{
        return("""{"nome" : "${this.nome}",
            "email" : "${this.email}",
            "senha" : "${this.senha}",
            "endereco" : null,
            "imagem" : null,
            "cpfCnpj" : "${this.cpf_cnpj}",
            "RG" : "${this.rg}",
            "telefone" : "${this.telefone}",
            "prestador" : ${prestador},
            "sexo" : "${sexo}",
            "estadoCivil" : "${this.estado_civil}",
            "dataNascimento" : "${this.data_nascimento}"}""")

    }


    fun streamingJson(jsonString: String?) : Usuario {

        var jsonObject = JSONObject(jsonString)

        var endereco = Endereco(
        )


        var usuario = Usuario(
            jsonObject.getInt("id"),
            jsonObject.getString("rg"),
            jsonObject.getString("cpfCnpj"),
            jsonObject.getString("dataNascimento"),
            jsonObject.getString("email"),
            jsonObject.getString("estadoCivil"),
            jsonObject.getString("nome"),
            jsonObject.getBoolean("prestador"),
            jsonObject.getString("senha"),
            jsonObject.getString("sexo"),
            jsonObject.getString("telefone"),
            endereco
        )

        return usuario
    }
}