package com.example.idosplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CadastroUsuarioAcessoConta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_usuario_acesso_conta)
    }

    fun bt_proximo(v:View){
        var cad = Intent(this, CadastroUsuarioDadosPessoaisActivity::class.java)


        var campoEmail = findViewById(R.id.campoEmail) as EditText
        var campoTelefone = findViewById(R.id.campoTelefone) as EditText
        var campoSenha = findViewById(R.id.campoSenha) as EditText
        var campoConfirmaSenha = findViewById(R.id.campoConfirmaSenha) as EditText

        var email = campoEmail.text.toString()
        var telefone = campoTelefone.text.toString()
        var senha = campoSenha.text.toString()
        var confirmaSenha = campoConfirmaSenha.text.toString()

        // enviando valores para a outra activity
        cad.putExtra("email", email)
        cad.putExtra("telefone", telefone)
        cad.putExtra("senha", senha)
        cad.putExtra("confirmarSenha", confirmaSenha)

        startActivity(cad)
    }
}
