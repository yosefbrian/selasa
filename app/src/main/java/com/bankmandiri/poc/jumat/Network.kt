package com.bankmandiri.poc.jumat

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Network {

    val BASE_URL = "http://dummy.restapiexample.com/api/v1/"
    fun provideNetwork(): Services{
        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(Services::class.java)


    }

}