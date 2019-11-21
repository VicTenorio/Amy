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


class MainActivity : AppCompatActivity() {

    lateinit var adapter: MyAdapter
    lateinit var itemList:MutableList<MyModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeToLogin()
        //InitData()
        //setData()
    }
/*
    private fun setData() {
        adapter = MyAdapter(this,itemList)

        val layoutManager = GridLayoutManager(this, Common.NUM_OF_COLUMN)
        layoutManager.orientation = RecyclerView.VERTICAL
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
        recycler_view.addItemDecoration(SpacesItemDescoration(8))
        recycler_view.adapter = adapter

    }*/

   /* private fun InitData(){

        itemList = ArrayList()

        itemList.add(MyModel(R.drawable.me_time, "Me"))
        itemList.add(MyModel(R.drawable.family_time, "family"))
        itemList.add(MyModel(R.drawable.lovely_time, "lovely"))
        itemList.add(MyModel(R.drawable.team_time, "team"))
        itemList.add(MyModel(R.drawable.friends, "friends"))
        itemList.add(MyModel(R.drawable.calendar, "calendar"))
        //itemList.add(MyItems(R.drawable.me_time, "MW"))
        //itemList.add(MyItems(R.drawable.me_time, "MW"))
    }*/

    fun changeToLogin()  {

        val intent = Intent(this, LoginActivity::class.java)

        Handler().postDelayed({
            intent.change()
        },2000)

    }
    fun Intent.change(){


        startActivity(this)
        finish()
    }

}




