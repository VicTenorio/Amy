package com.example.idosplashscreen

import android.content.AbstractThreadedSyncAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idosplashscreen.Adapter.ServiceAdapter
import com.example.idosplashscreen.Common.Common
import com.example.idosplashscreen.Common.SpacesItemDescoration
import com.example.idosplashscreen.Model.Http
import com.example.idosplashscreen.Model.Service
import kotlinx.android.synthetic.main.activity_grid_categorias.*
import kotlinx.android.synthetic.main.activity_service.*


class ServiceActivity : AppCompatActivity() {

    lateinit var adapter: ServiceAdapter
    lateinit var serviceList:ArrayList<Service>
    lateinit var listItems:ArrayList<Service>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        InitData()
        setData()
    }

    private fun setData() {
        //============================
        // Construção do Grid Layout
        //============================
        //adapter = ServiceAdapter(this,serviceList) // instancia do adapter
        adapter = ServiceAdapter(this,listItems)
        val layoutManager = GridLayoutManager(this, 1)// Define o numero de columas do Grid
        layoutManager.orientation = RecyclerView.VERTICAL // define o orientarion do Grid
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(i: Int): Int {
                return if (adapter != null){
                    when(adapter!!.getItemViewType(i))
                    {
                        1 -> 1
                        0 -> 1
                        else -> - 1
                    }
                }else{
                    -1
                }
            }
        }

        service_list_view.layoutManager = layoutManager
        service_list_view.addItemDecoration(SpacesItemDescoration(6))
        service_list_view.adapter = adapter

    }

    private fun InitData(){


/*
        val array = """[
            {
                "id":4,
                "imagem": "https://certificadocursosonline.com/wp-content/uploads/2018/07/curso-de-mecanica.jpg",
                "descricao": "Mecanico",
                "idCategoria":1
            },
            {
                "id":5,
                "imagem": "https://www.boxtop.com.br/wp-content/uploads/2019/03/5-dicas-para-montar-uma-oficina-mec%C3%A2nica-boxtop-1200x8501.jpeg",
                "descricao": "Mecanico",
                "idCategoria":1
            },
            {
                "id":6,
                "imagem": "https://grupoiep.com.br/wp-content/uploads/2017/10/t%C3%A9cnico_em_inform%C3%A1tica.jpg",
                "descricao": "Técnico de hardware",
                "idCategoria":2
            },
            {
                "id":7,
                "imagem": "https://pronatec.pro.br/wp-content/uploads/2017/11/T%C3%A9cnico-em-Inform%C3%A1tica-Senac-2018.jpg",
                "descricao": "Técnico de hardware",
                "idCategoria":2
            },
            {
                "id":8,
                "imagem": "http://contratedomestica.com.br/v3/wp-content/uploads/2017/06/empregada-300x274.png",
                "descricao": "Empregada doméstica",
                "idCategoria":3
            },
            {
                "id":9,
                "imagem": "https://cptstatic.s3.amazonaws.com/imagens/enviadas/materias/materia6218/tarefas-das-empregadas-domesticas-cursos-cpt.jpg",
                "descricao": "Empregada doméstica",
                "idCategoria":3
            },
            {
                "id":10,
                "imagem": "https://www.gazetadopovo.com.br/viver-bem/wp-content/uploads/2019/02/pedreiro-6-600x450.jpg",
                "descricao": "pedreiro",
                "idCategoria":4
            },
            {
                "id":11,
                "imagem": "https://www.resdil.com.br/wp-content/uploads/2018/06/contratar-pedreiros-1-750x425.jpg",
                "descricao": "pedreiro",
                "idCategoria":4
            },
            {
                "id":12,
                "imagem": "https://canaldoensino.com.br/blog/wp-content/uploads/2016/06/particular.jpg",
                "descricao": "professora particular",
                "idCategoria":5
            },
            {
                "id":13,
                "imagem": "https://canaldoensino.com.br/blog/wp-content/uploads/2017/01/7-dicas-para-se-tornar-um-professor-particular.jpg",
                "descricao": "professor particular",
                "idCategoria":5
            },
            {
                "id":14,
                "imagem": "https://www.carolecrema.com.br/system/ckeditor_assets/pictures/14/content_captura_de_tela_2018-06-05_as_14_11_39.png",
                "descricao": "sedex",
                "idCategoria":6
            },
            {
                "id":15,
                "imagem": "https://mototurbogoiania.com/wp-content/uploads/2018/03/mototurbo-motoboy-progresso-quanto-custa-porta-a-porta-entregas-de-expresso.png",
                "descricao": "entregas",
                "idCategoria":6
            },
            {
                "id":16,
                "imagem": "https://st3.depositphotos.com/11233746/17636/i/450/depositphotos_176363992-stock-photo-cropped-image-hairdresser-trimming-ends.jpg",
                "descricao": "cabeleleiro",
                "idCategoria":7
            },
            {
                "id":17,
                "imagem": "https://megasmartcursos.com.br/wp-content/uploads/2019/02/curso-cabeleireiro-900x550-min.jpg",
                "descricao": "cabeleleiro",
                "idCategoria":7
            },
            {
                "id":18,
                "imagem": "https://cdn.panrotas.com.br/portal-panrotas-statics/media-files-cache/283826/6f14f440252f7f94ed73cd80ca094a61audience16770281280/0,221,1024,611/670,400,0.36/0/default.jpg",
                "descricao": "organizador de eventos",
                "idCategoria":8
            },
            {
                "id":19,
                "imagem": "https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_800/https://www.imobmarketing.com.br/wp-content/uploads/2018/11/Conecta-Imobi-Evento-de-Marketing-Imobilia%CC%81rio.png",
                "descricao": "organizador de eventos",
                "idCategoria":8
            }
            
        ]"""
*/

        var idCategoriaHome = intent.getIntExtra("idCategoria", 0)
        val http = Http()
        var url = getString(R.string.api_raven_crown)+"/Servicos/Categoria?categoria="+idCategoriaHome+"&login=534"
        var array = http.get(url)

        serviceList = Service().streamingArray(array)//json de servicos

        //listItems = arrayOfNulls<String>(serviceList.size)
        //listItems = ArrayList<Service>(serviceList.size)
        listItems = ArrayList()
// 3


        for (i in 0 until serviceList.size) {
            val service = serviceList[i]
            if(service.idCategoria == idCategoriaHome){
                listItems.add(serviceList[i])
            }
        }

    }
}




