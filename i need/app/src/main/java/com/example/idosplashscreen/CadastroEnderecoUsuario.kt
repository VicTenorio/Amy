package com.example.idosplashscreen

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class CadastroEnderecoUsuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_endereco_usuario)
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

        var rua = campoRua.text.toString()
        var numeroMoradia = campoNumeroMoradia.text.toString()
        var referencia = campoReferencia.text.toString()
        var complemento = campoComplemento.text.toString()
        var CEP = campoCEP.text.toString()
        var bairro = campoBairro.text.toString()
        var cidade = campoCidade.text.toString()
        var estado = campoEstado.text.toString()

        println(email)
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
        println(estado)

    }
}
