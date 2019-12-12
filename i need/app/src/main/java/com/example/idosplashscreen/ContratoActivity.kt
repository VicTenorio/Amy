package com.example.idosplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.idosplashscreen.Model.*
import kotlinx.android.synthetic.main.activity_contrato.*

class ContratoActivity : AppCompatActivity() {


    lateinit var contratoList: ArrayList<Contrato>
    lateinit var listItems: ArrayList<Contrato>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato)

        val http = Http()
        var url = getString(R.string.api_raven_crown)+"/Usuario?id=53"
        var array = http.get(url)

        var url2 = getString(R.string.api_raven_crown)+"/Usuario?id=55"
        var array2 = http.get(url2)

        var usuario = Usuario().streamingJson(array)
        var usuario2 = Usuario().streamingJson(array2)

        //contratoList = Contrato().streamingArray(array)


        var texto = "Contrato\n" +
                "\n" +
                "${usuario.nome} solicitou no dia(09/12/2019)\n" +
                "para ${usuario2.nome} que realizasse o serviço de " +
                "Mecanico" +
                " na," +
                "" +
                " Rua Portugal com previsão\n" +
                "de tempo de conclusão para (14/12/2019)\n" +
                "pelo valor (\$ 20.00)\n" +
                "\n" +
                "fechar contrato?"

        fecharNegocio.text = texto
    }

    fun negocioFechado(view:View){

        var home = Intent(this, HomeActivity::class.java)
        // enviando valores para a outra activity
        home.putExtra("idUsuario", UsuarioLogado.idUsuario)
        home.putExtra("nome", UsuarioLogado.nomeUsuario)

        Toast.makeText(this, "Agendado com sucesso", Toast.LENGTH_LONG).show()

        startActivity(home)
    }

}