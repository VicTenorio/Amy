package com.example.idosplashscreen


import android.os.Bundle
import android.os.StrictMode
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.idosplashscreen.Model.Endereco
import com.example.idosplashscreen.Model.Http
import com.example.idosplashscreen.Model.Usuario
import kotlinx.android.synthetic.main.activity_cadastro_dados_usuarios.*

class CadastroDadosUsuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_dados_usuarios)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

    fun cadastro(v: View){

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
        var RG = campoRG.text.toString()
        var numeroMoradia = campoNumeroMoradia.text.toString()
        var referencia = campoReferencia.text.toString()
        var complemento = campoComplemento.text.toString()
        var CEP = campoCEP.text.toString()
        var bairro = campoBairro.text.toString()
        var cidade = campoCidade.text.toString()
        var estado = campoEstado.text.toString()
        var pais = campoPais.text.toString()



        var CPF = campoCPF.text.toString()
        var dtNasc = campoDtNasc.text.toString()
        var email = campoEmail.text.toString()
        var nomeCompleto = campoNomeCompleto.text.toString()
        var senha = campoSenha.text.toString()
        var telefone = campoTelefone.text.toString()

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

        var url = getString(R.string.api_raven_crown) + "/cadastro"

        print("usuario>>>"+usuario.toJson())
        http.post(url,usuario.toJson())
    }
}