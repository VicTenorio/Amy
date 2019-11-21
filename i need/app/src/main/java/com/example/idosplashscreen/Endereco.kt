package com.example.idosplashscreen

data class Endereco (private var id: Int,

                     private var rua: String?,

                     private var cep: String?,

                     private var complemento: String?,

                     private var numero: String?,

                     private var referencia: String?,

                     private var bairro: String?,

                     private var cidade: String?,

                     private var estado: String?,

                     private var pais: String?)
{

    constructor():this(
        0,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null)


    fun toJson() : String{
        return(
                """{"rua" : "${this.rua}",
            "cep" : "${this.cep}",
            "complemento" : "${this.complemento}",
            "numero" : ${this.numero},
            "referencia" : ${this.referencia},
            "bairro" : "${this.bairro}",
            "cidade" : "${this.cidade}",
            "estado" : "${this.estado}",
            "pais" : "${this.pais}"}""")

    }
}