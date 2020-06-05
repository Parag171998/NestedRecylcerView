package com.example.wenesdaytaskkotlin.Network

import com.example.nestedrecyclerview.Models.ItemItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("show.json")
    fun getIteams(): Call<List<ItemItem>?>
}