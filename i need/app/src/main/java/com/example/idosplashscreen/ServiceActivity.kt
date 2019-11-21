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
import com.example.idosplashscreen.Model.Service
import kotlinx.android.synthetic.main.activity_grid_categorias.*
import kotlinx.android.synthetic.main.activity_service.*


class ServiceActivity : AppCompatActivity() {

    lateinit var adapter: ServiceAdapter
    lateinit var serviceList:ArrayList<Service>


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
        adapter = ServiceAdapter(this,serviceList) // instancia do adapter

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

        val array = """[
            {
                "imagem": "https://f.i.uol.com.br/fotografia/2019/03/15/15526795065c8c025270c53_1552679506_4x3_lg.jpg",
                "descricao": "descricao1"
            },
            {
                "imagem": "C:\\Users\\wesle\\Desktop\\background\\Rain\\a.jpg",
                "descricao": "descricao2dfsdf"
            }
        ]"""

        serviceList = Service().streamingArray(array)//json de servicos

        val listItems = arrayOfNulls<String>(serviceList.size)
// 3
        for (i in 0 until serviceList.size) {
            val service = serviceList[i]
            listItems[i] = service.descricao
            listItems[i] = service.imagem
        }
    }
}




