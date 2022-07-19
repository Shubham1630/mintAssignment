package com.srp.assignment.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    var retrofitService: OkHttpIssuesService? = null

    fun getInstance(url:String) : OkHttpIssuesService {

        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(OkHttpIssuesService::class.java)
        }
        return retrofitService!!
    }
}