package com.example.idosplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class CadastroUsuarioDadosPessoaisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario_dados_pessoais)
    }

    fun bt_proximo(v: View){
        var cad = Intent(this, CadastroEnderecoUsuario::class.java)

        val email = intent.getStringExtra("email")
        val telefone = intent.getStringExtra("telefone")
        val senha = intent.getStringExtra("senha")
        val confirmarSenha = intent.getStringExtra("confirmarSenha")

        var campoNomeCompleto = findViewById(R.id.campoNomeCompleto) as EditText
        var campoRG = findViewById(R.id.campoRG) as EditText
        var campoCPF = findViewById(R.id.campoCPF) as EditText
        var campoDtNasc = findViewById(R.id.campoDtNasc) as EditText

        var nomeCompleto = campoNomeCompleto.text.toString()
        var RG = campoRG.text.toString()
        var CPF = campoCPF.text.toString()
        var dtNasc = campoDtNasc.text.toString()

        // enviando valores para a outra activity
        cad.putExtra("email", email)
        cad.putExtra("telefone", telefone)
        cad.putExtra("senha", senha)
        cad.putExtra("confirmarSenha", confirmarSenha)
        cad.putExtra("nomeCompleto", nomeCompleto)
        cad.putExtra("RG", RG)
        cad.putExtra("CPF", CPF)
        cad.putExtra("dtNasc", dtNasc)


        var user = Usuario()

        user.id_usuario = 0
        user.rg = RG
        user.cpf_cnpj = CPF
        user.data_nascimento = dtNasc
        user.email  = email
        user.estado_civil = "Indefinido"
        user.nome = nomeCompleto
        user.prestador = false
        user.senha = ""
        user.sexo = "Indefinido"
        user.telefone = telefone
        user.endereco = ""

        sendPostRequest(user)

        startActivity(cad)
    }

    fun sendPostRequest(usuario:Usuario) {

        var reqParam = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(usuario.toJson(), "UTF-8")
        val mURL = URL("https://ravenamy.azurewebsites.net/cadastro")

        with(mURL.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "POST"

            val wr = OutputStreamWriter(getOutputStream());
            wr.write(reqParam);
            wr.flush();

            println("URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                it.close()
                println("Response : $response")
            }
        }
    }
}
