package com.example.my_arz

class ArzList {

    var coins: List<Arz>? = null
    private fun  getcoins(): List<Arz>? {

        return coins
    }

    private fun setcoins(apicoin: List<Arz>? ){


        coins = apicoin
    }


}