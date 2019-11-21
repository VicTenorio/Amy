package com.example.idosplashscreen

import android.content.AbstractThreadedSyncAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idosplashscreen.Adapter.MyAdapter
import com.example.idosplashscreen.Common.Common
import com.example.idosplashscreen.Common.SpacesItemDescoration
import com.example.idosplashscreen.Model.MyModel
import kotlinx.android.synthetic.main.activity_grid_categorias.*


class GridCategorias : AppCompatActivity() {

    lateinit var adapter: MyAdapter
    lateinit var itemList:MutableList<MyModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_categorias)

        InitData()
        setData()
    }

    private fun setData() {
        //============================
        // Construção do Grid Layout
        //============================
        adapter = MyAdapter(this,itemList) // instancia do adapter

        val layoutManager = GridLayoutManager(this, Common.NUM_OF_COLUMN)// Define o numero de columas do Grid
        layoutManager.orientation = RecyclerView.VERTICAL // define o orientarion do Grid
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(i: Int): Int {
                return if (adapter != null){
                    when(adapter!!.getItemViewType(i))
                    {
                        1 -> 1
                        0 -> Common.NUM_OF_COLUMN
                        else -> - 1
                    }
                }else{
                    -1
                }
            }
        }

        recycler_view.layoutManager = layoutManager
        recycler_view.addItemDecoration(SpacesItemDescoration(6))
        recycler_view.adapter = adapter

    }

    private fun InitData(){
        itemList = ArrayList()

        itemList.add(MyModel(1,R.drawable.car, getString(R.string.grid_auto)))
        itemList.add(MyModel(2,R.drawable.website, getString(R.string.grid_informaticaTecnologia)))
        itemList.add(MyModel(3,R.drawable.house, getString(R.string.grid_Domesticos)))
        itemList.add(MyModel(4,R.drawable.brickwall, getString(R.string.grid_construção)))
        itemList.add(MyModel(5,R.drawable.mortarboard, getString(R.string.grid_educacao)))
        itemList.add(MyModel(6,R.drawable.box, getString(R.string.grid_entregasEncomendas)))
        itemList.add(MyModel(7,R.drawable.salon, getString(R.string.grid_exteticaModa)))
        itemList.add(MyModel(8,R.drawable.calendario, getString(R.string.grid_eventosMusicasDecoracoes)))
    }

}




