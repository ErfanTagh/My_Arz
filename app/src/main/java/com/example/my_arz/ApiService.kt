package com.example.my_arz

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/coins/")
    suspend fun getUsers(): ArzList

    @GET("api/arz/")
    suspend fun getDollar(): Dollar

}