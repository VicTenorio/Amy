package com.example.idosplashscreen


import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.idosplashscreen.Model.Service
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes_servico.*
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import java.text.SimpleDateFormat
import java.util.*

class DetalhesServico : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalhes_servico)
        val textView: TextView  = findViewById(R.id.tvModal)
        textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView.text = sdf.format(cal.time)

        }

        textView.setOnClickListener {
            DatePickerDialog(this, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        setData()
    }

    fun setData(){
        val data = """
            {
                "id":4,
                "idUsuario":4,
                "endereco":null,
                "idCategoria": 4,
                "imagem": "https://f.i.uol.com.br/fotografia/2019/03/15/15526795065c8c025270c53_1552679506_4x3_lg.jpg",
                "nome": "Wesley",
                "descricao": "descricao1",
                "tempoExecucao":"4horas",
                "preco":"20.00",
                "localizacaoFixa":True
            }"""

        var service = Service().streamingJson(data)

        nome_servico.text = nome_servico.text.toString()+" "+service.nome
        categoria_servico.text = categoria_servico.text.toString()+" "+service.idCategoria.toString()
        preco_servico.text = preco_servico.text.toString()+" "+service.preco.toString()
        tempo_servico.text = tempo_servico.text.toString()+" "+service.tempoExecucao
        localizacao_servico.text = localizacao_servico.text.toString()+" "+service.localizacaoFixa.toString()
        descricao_servico.text = descricao_servico.text.toString()+" "+service.descricao

        Picasso
            .get()//.with(context)
            .load(service.imagem)//service.Imagem
            .placeholder(R.mipmap.ic_launcher)
            .into(imagem_servico)
    }

}
