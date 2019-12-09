package com.example.idosplashscreen


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idosplashscreen.Common.SpacesItemDescoration
import com.example.idosplashscreen.Model.Http
import com.example.idosplashscreen.Model.Service
import kotlinx.android.synthetic.main.activity_service.*
import com.example.idosplashscreen.Adapter.MeusServicosAdapter as MeusServicosAdapter



class MeusServicos : AppCompatActivity() {

    lateinit var adapter: MeusServicosAdapter
    lateinit var serviceList:ArrayList<Service>
    lateinit var listItems:ArrayList<Service>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_servicos)

        InitData()
        setData()
    }

    private fun setData() {
        //============================
        // Construção do Grid Layout
        //============================
        //adapter = ServiceAdapter(this,serviceList) // instancia do adapter
        adapter = MeusServicosAdapter(this,listItems)
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

    var idCategoriaHome = intent.getIntExtra("idCategoria", 0)
    val http = Http()
    var url = getString(R.string.api_raven_crown)+"/ValeryAPI/Usuario/Contratos?id=55"
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
