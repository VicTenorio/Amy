package com.example.idosplashscreen.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.idosplashscreen.R

class MeusServicosFragment: Fragment() {

    private lateinit var meusServicosModelView: MeusServicosViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_meus_servicos, container, false)
        /*val textView: TextView = root.findViewById(R.id.service_price)
        meusServicosModelView.text.observe(this, Observer {
            textView.text = it
        })*/
        return root
    }
}