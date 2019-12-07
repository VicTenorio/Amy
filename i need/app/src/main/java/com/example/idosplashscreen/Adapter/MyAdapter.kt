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
import com.example.idosplashscreen.Interface.IcardIntemClickListener
import com.example.idosplashscreen.Model.MyModel
import com.example.idosplashscreen.R
import com.example.idosplashscreen.ServiceActivity

class MyAdapter(internal var  context: Context,
                internal var myItems: List<MyModel>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.layout_card_square,p0,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return myItems.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.img_icon.setImageResource(myItems[p1].icon)
        p0.txt_description.text = myItems[p1].description


        //==========================================
        // Define o OnClick dos items no gridView
        //==========================================
        p0.setEvent(object :IcardIntemClickListener{
            override fun onCartItemClick(view: View, position: Int) {
                //Toast.makeText(context,"Clicked >>>>>:"+ myItems[position].idServico,Toast.LENGTH_SHORT).show()

                var cad = Intent(view.context,ServiceActivity::class.java)
                cad.putExtra("idCategoria", myItems[position].idServico)
                ContextCompat.startActivity(view.context,cad,null)

            }
        })
    }


    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener {
        internal var img_icon:ImageView
        internal var txt_description:TextView
        internal  lateinit var iCardItemClikListener:IcardIntemClickListener

        fun setEvent(icardIntemClickListener: IcardIntemClickListener)
        {
            this.iCardItemClikListener = icardIntemClickListener
        }

        init {
            img_icon =itemView.findViewById<View>(R.id.img_icon) as ImageView
            txt_description = itemView.findViewById(R.id.txt_descripition) as TextView

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






