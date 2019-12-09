package com.example.idosplashscreen.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeusServicosViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Services Fragment"
    }
    val text: LiveData<String> = _text
}