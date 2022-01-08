package com.example.practice7

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel  : ViewModel() {
//    val editT: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val checkB : MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val togleB: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val r1: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val r2: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val textV: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    fun onButClicked(): String{
        val str = "CheckBox:${if (checkB.value?:false) "ON" else "OFF"}" +
                "\nToggleButton:${if (togleB.value?:false) "ON" else "OFF"}"+
                "\nRadioGroup:${if (r1.value?:false) "RadioButton 1" else "RadioButton 2"}"
        return str
    }

}