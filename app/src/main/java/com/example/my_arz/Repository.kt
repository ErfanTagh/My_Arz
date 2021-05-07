package com.example.my_arz

class Repository {

    suspend fun getArz(): ArzList{


        return  ApiClient.apiService.getUsers()
    }


    suspend fun getDollar(): Dollar {

        return  ApiClient.apiService.getDollar()
    }

}