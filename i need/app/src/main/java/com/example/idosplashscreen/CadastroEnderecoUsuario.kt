package com.example.idosplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.EditText
import com.example.idosplashscreen.Model.Endereco
import com.example.idosplashscreen.Model.Http
import com.example.idosplashscreen.Model.Usuario

class CadastroEnderecoUsuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_endereco_usuario)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

    fun cadastro(v:View){

        val email = intent.getStringExtra("email")
        val telefone = intent.getStringExtra("telefone")
        val senha = intent.getStringExtra("senha")
        val confirmarSenha = intent.getStringExtra("confirmarSenha")
        var nomeCompleto = intent.getStringExtra("nomeCompleto")
        var RG = intent.getStringExtra("RG")
        var CPF = intent.getStringExtra("CPF")
        var dtNasc = intent.getStringExtra("dtNasc")

        var campoRua = findViewById(R.id.campoRua) as EditText
        var campoNumeroMoradia = findViewById(R.id.campoNumeroMoradia) as EditText
        var campoReferencia = findViewById(R.id.campoReferecia) as EditText
        var campoComplemento = findViewById(R.id.campoComplemento) as EditText
        var campoCEP = findViewById(R.id.campoCEP) as EditText
        var campoBairro = findViewById(R.id.campoBairro) as EditText
        var campoCidade = findViewById(R.id.campoCidade) as EditText
        var campoEstado = findViewById(R.id.campoEstado) as EditText
        var campoPais = findViewById(R.id.campoPais) as EditText

        var rua = campoRua.text.toString()
        var numeroMoradia = campoNumeroMoradia.text.toString()
        var referencia = campoReferencia.text.toString()
        var complemento = campoComplemento.text.toString()
        var CEP = campoCEP.text.toString()
        var bairro = campoBairro.text.toString()
        var cidade = campoCidade.text.toString()
        var estado = campoEstado.text.toString()
        var pais = campoPais.text.toString()

        var endereco: Endereco =
            Endereco(
                0,
                rua,
                CEP,
                complemento,
                numeroMoradia,
                referencia,
                bairro,
                cidade,
                estado,
                pais
            )
        var usuario: Usuario =
            Usuario(
                0,
                RG,
                CPF,
                dtNasc,
                email,
                "estado_civil",
                nomeCompleto,
                true,
                senha,
                "M",
                telefone,
                endereco
            )

        val http = Http()

        var url = getString(R.string.api_cadastro_usuario)

        print("usuario>>>"+usuario.toJson())
        //print("ALGUMACOISA>>>>>"+http.post(url,usuario.toJson()))

        /*println(email)
        println(telefone)
        println(senha)
        println(confirmarSenha)
        println(nomeCompleto)
        println(RG)
        println(CPF)
        println(dtNasc)
        println(rua)
        println(numeroMoradia)
        println(referencia)
        println(complemento)
        println(CEP)
        println(bairro)
        println(cidade)
        println(estado)*/

    }
}
