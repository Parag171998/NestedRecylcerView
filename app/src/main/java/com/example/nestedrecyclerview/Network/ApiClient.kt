package com.example.wenesdaytaskkotlin.Network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object ApiClient {

    private var BASE_URL: String = "https://d51md7wh0hu8b.cloudfront.net/android/v1/prod/Radio/hi/"
    private var apiClient2: ApiClient? = null
    private var retrofit: Retrofit? = null

    init {

        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getInstance(): ApiClient? {
        if (apiClient2 == null) {
            apiClient2 = ApiClient
        }
        return apiClient2
    }

    fun getApi(): ApiInterface? {
        return retrofit?.create(ApiInterface::class.java)
    }

}
