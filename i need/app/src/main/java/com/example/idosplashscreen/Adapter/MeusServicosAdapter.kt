package com.example.idosplashscreen.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.idosplashscreen.Common.Common
import com.example.idosplashscreen.DetalhesServico
import com.example.idosplashscreen.Interface.IcardIntemClickListener
import com.example.idosplashscreen.Model.Service
import com.example.idosplashscreen.R
import com.example.idosplashscreen.ServiceActivity
import com.squareup.picasso.Picasso

class  MeusServicosAdapter(internal var  context: Context,
                     internal var myItems: ArrayList<Service>):RecyclerView.Adapter<MeusServicosAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.list_item_service,p0,false)
        return MyViewHolder(itemView)
    }

    // lets ListView know how many items to display, or in other words, it returns the size of your data source.
    override fun getItemCount(): Int {
        return myItems.size
    }

    //  the getItemId() method that defines a unique ID for each row in the list.
    //  For simplicity, you just use the position of the item as its ID.
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        //p0.img_icon.setImageResource(myItems[p1].icon)
        //p0.txt_description.text = myItems[p1].description

        p0.descricao.text = myItems[p1].nome
        //p0.preco.text = myItems[p1].preco
/*
        Picasso
            .get()//.with(context)
            .load(myItems[p1].imagem)//service.Imagem
            .placeholder(R.mipmap.ic_launcher)
            .into(p0.imagem)
*/
        //==========================================
        // Define o OnClick dos items no gridView
        //==========================================
        p0.setEvent(object :IcardIntemClickListener{
            override fun onCartItemClick(view: View, position: Int) {
                //Toast.makeText(context,"Clicked:"+ myItems[position].id,Toast.LENGTH_SHORT).show()

                var detalhes = Intent(view.context, DetalhesServico::class.java)
                //detalhes.putExtra("imagem", myItems[position].imagem)
                detalhes.putExtra("descricao", myItems[position].descricao)
                detalhes.putExtra("nome", myItems[position].nome)
                ContextCompat.startActivity(view.context, detalhes, null)

            }
        })
    }


    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener {
        internal var imagem:ImageView
        internal var descricao:TextView
        internal  lateinit var iCardItemClikListener:IcardIntemClickListener

        fun setEvent(icardIntemClickListener: IcardIntemClickListener)
        {
            this.iCardItemClikListener = icardIntemClickListener
        }

        init {
            imagem =itemView.findViewById<View>(R.id.service_image) as ImageView
            descricao = itemView.findViewById(R.id.service_description) as TextView

            itemView.setOnClickListener(this)

        }
        override fun onClick(p0: View?) {

            iCardItemClikListener.onCartItemClick(p0!!,adapterPosition)

        }
    }

    override fun getItemViewType(position: Int): Int {
        return  if(myItems.size == 1)
            0
        else{
            if(myItems.size % Common.NUM_OF_COLUMN ==0)
                1
            else
                if(position > 1 && position == myItems.size - 1) 0 else 1
        }
    }

}

