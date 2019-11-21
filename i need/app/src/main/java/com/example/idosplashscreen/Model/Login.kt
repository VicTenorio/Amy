package com.example.idosplashscreen.Model

data class Login (
    var email:String?,
    var senha:String?
){
    constructor():this("","")

    fun toJson() : String{
        return(
                """{"email" : "${this.email}",
                "senha" : "${this.senha}"}""")
    }
}
