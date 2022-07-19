package com.srp.assignment.service


import com.srp.assignment.model.SquareIssuesDataClassItem
import com.srp.assignment.model.comments.CommentsItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url


interface OkHttpIssuesService {

    @GET("okhttp/issues")
    fun issuesList(
    ): Call<ArrayList<SquareIssuesDataClassItem>>

    @GET("comments")
    fun getCommentList(): Call<List<CommentsItem>>?

}