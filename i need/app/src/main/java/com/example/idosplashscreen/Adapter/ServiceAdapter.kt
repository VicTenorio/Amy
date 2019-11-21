package com.example.idosplashscreen.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.idosplashscreen.Model.Service
import com.example.idosplashscreen.R
import com.squareup.picasso.Picasso

class ServiceAdapter(private val context: Context,
                              private val dataSource: ArrayList<Service>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    // creates a view to be used as a row in the list.
    // Here you define what information shows and where it sits within the ListView.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_service, parent, false)

        // Get serviceDescription element
        val serviceDescription = rowView.findViewById(R.id.service_description) as TextView

        // Get serviceImage element
        val serviceImage = rowView.findViewById(R.id.service_image) as ImageView

        val service = getItem(position) as Service

        serviceDescription.text = service.descricao

        Picasso
            .get()//.with(context)
            .load(service.imagem)//service.Imagem
            .placeholder(R.mipmap.ic_launcher)
            .into(serviceImage)


        return rowView
    }

    // returns an item to be placed in a given position from the data source,
    // specifically, Recipe objects obtained from dataSource.
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //  the getItemId() method that defines a unique ID for each row in the list.
    //  For simplicity, you just use the position of the item as its ID.
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // lets ListView know how many items to display, or in other words, it returns the size of your data source.
    override fun getCount(): Int {
        return dataSource.size
    }
}