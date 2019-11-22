package com.example.idosplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.idosplashscreen.Model.UsuarioLogado

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = intent.getIntExtra("idUsuario", 0)
        val nome = intent.getStringExtra("nome")

        var txt_nome = findViewById(R.id.nome_usuario) as TextView

        txt_nome.text = " nome:"+nome.toString() +" id:"+ id.toString()
    }

    fun logout(v:View){
        var login = Intent(this, LoginActivity::class.java)

        UsuarioLogado.idUsuario = 0
        UsuarioLogado.nomeUsuario = ""

        startActivity(login)
    }
}
