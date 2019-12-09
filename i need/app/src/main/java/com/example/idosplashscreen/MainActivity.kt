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
    }

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




