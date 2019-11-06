package com.example.idosplashscreen

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
                    var endereco: String
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
                        "")

    fun toJson() : String{
        return(
        """"{"nome" : "${this.nome}",
            "email" : "${this.email}",
            "senha" : "${this.senha}",
            "id" : ${this.id_usuario},
            "endereco" : ${this.endereco},
            "imagem" : null,
            "cpfCnpj" : "${this.cpf_cnpj}",
            "RG" : "${this.rg}",
            "telefone" : "${this.telefone}",
            "prestador" : false,
            "sexo" : "M",
            "estadoCivil" : "Solteiro",
            "dataNascimento" : "${this.data_nascimento}"}""")

    }
}