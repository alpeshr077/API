package com.alpesh1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {

    companion object{

        val  BASE_URL = "https://jsonplaceholder.typicode.com/"
        lateinit var retrofit: Retrofit

        fun getApiClient(): Retrofit {

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit

        }

    }

}