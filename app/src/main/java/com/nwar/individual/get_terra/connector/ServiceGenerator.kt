package com.nwar.individual.get_terra.connector

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator(){
    val URL = "http://ec2.istruly.sexy:1234/"
    val httpClient = OkHttpClient.Builder()
    val builder = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build()
    fun <T>createService(serviceClass : Class<T>) = builder.create(serviceClass)
}