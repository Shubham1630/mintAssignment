package com.srp.assignment.service


import com.srp.assignment.model.SquareIssuesDataClassItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.github.com/repos/square/"

interface OkHttpIssuesService {

    @GET("okhttp/issues")
    fun issuesList(
    ): Call<ArrayList<SquareIssuesDataClassItem>>


    companion object {

        var retrofitService: OkHttpIssuesService? = null

        fun getInstance() : OkHttpIssuesService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(OkHttpIssuesService::class.java)
            }
            return retrofitService!!
        }
    }

//    @GET("okhttp/issues")
//    fun issuesList(
//    ): Call<ArrayList<SquareIssuesDataClassItem>>
//
//
//    companion object {
//
//        var retrofitService: OkHttpIssuesService? = null
//
//        fun getInstance() : OkHttpIssuesService {
//
//            if (retrofitService == null) {
//                val retrofit = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                retrofitService = retrofit.create(OkHttpIssuesService::class.java)
//            }
//            return retrofitService!!
//        }
//    }




}