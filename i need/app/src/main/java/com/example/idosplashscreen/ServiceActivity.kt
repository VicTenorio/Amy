package com.example.idosplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.idosplashscreen.Adapter.ServiceAdapter
import com.example.idosplashscreen.Model.Service
import org.json.JSONObject

class ServiceActivity : AppCompatActivity() {
    var array = arrayOf("Melbourne", "Vienna", "Vancouver", "Toronto", "Calgary", "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York", "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val listView = findViewById<ListView>(R.id.service_list_view)
// 1
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

        val serviceList = Service().streamingArray(array)//json de servicos
// 2
        val listItems = arrayOfNulls<String>(serviceList.size)
// 3
        for (i in 0 until serviceList.size) {
            val service = serviceList[i]
            listItems[i] = service.descricao
            listItems[i] = service.imagem
        }
// 4
        val adapter = ServiceAdapter(this, serviceList)
        listView.adapter = adapter

        /*
        val adapter = ArrayAdapter(this,
            R.layout.list_item_service, array)

        val listView:ListView = findViewById(R.id.service_list_view)
        listView.setAdapter(adapter)

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {

            override fun onItemClick(parent: AdapterView<*>, view: View,
                                     position: Int, id: Long) {

                // value of item that is clicked
                val itemValue = listView.getItemAtPosition(position) as String

                // Toast the values
                Toast.makeText(applicationContext,
                    "Position :$position\nItem Value : $itemValue", Toast.LENGTH_LONG)
                    .show()
            }

        }

        */
    }


}
