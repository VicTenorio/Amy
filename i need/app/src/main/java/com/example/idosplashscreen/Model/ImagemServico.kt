package com.example.idosplashscreen.Model

data class ImagemServico (var id: Int
                          ,var idServico: Int
                          ,var idUsuario: Int
                          ,var url: String?
                          ,var image: ByteArray? = null){

    constructor():this(
        0,0,0,"",null
    )

    fun toJson() : String{
        return("""{"idServico" : "${this.idServico}",
            "idUsuario" : "${this.idUsuario}",
            "url" : "${this.url}",
            "imagem" : "${this.image}"}""")

    }
}