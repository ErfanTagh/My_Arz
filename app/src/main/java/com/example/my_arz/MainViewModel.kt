package com.example.my_arz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {



    val myResponse : MutableLiveData<List<Arz>> = MutableLiveData()
    private val arzes: ArrayList<Arz> = ArrayList()
    val myResponseDollar : MutableLiveData<Dollar> = MutableLiveData()

    fun getArz(){


        viewModelScope.launch {

            val response = repository.getArz()
            myResponse.value = response.coins


        }
    }

    fun getDollar(){


        viewModelScope.launch {

            val response = repository.getDollar()
            myResponseDollar.value = response


        }
    }

}