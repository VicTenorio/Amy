package com.example.idosplashscreen

import android.content.Intent
import android.os.Bundle
import android.view.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idosplashscreen.Adapter.MyAdapter
import com.example.idosplashscreen.Common.Common
import com.example.idosplashscreen.Common.SpacesItemDescoration
import com.example.idosplashscreen.Model.MyModel
import kotlinx.android.synthetic.main.activity_grid_categorias.*
import kotlinx.android.synthetic.main.activity_grid_categorias.recycler_view
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_home.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.nav_header_home.*
import kotlinx.android.synthetic.main.nav_header_home.view.*

class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var adapter: MyAdapter
    lateinit var itemList:MutableList<MyModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val id = intent.getIntExtra("idUsuario", 0)
        val nome = intent.getStringExtra("nome")
        

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val headerView = navigationView.getHeaderView(0)
        val navNameText = headerView.findViewById<View>(R.id.name_menu) as TextView
        val navEmailText = headerView.findViewById<View>(R.id.email_menu) as TextView
        navNameText.text = nome.toString()
        navEmailText.text = "wesley@teste"

        InitData()
        setData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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


    fun logout(item: MenuItem) {
        val tela2 = Intent(this,LoginActivity::class.java)
        startActivity(tela2)
    }

}
