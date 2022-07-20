package com.srp.assignment.service


import com.srp.assignment.model.okHttpIssues.SquareIssuesDataClassItem
import com.srp.assignment.model.comments.CommentsItem
import retrofit2.Call
import retrofit2.http.GET


interface OkHttpIssuesService {

    @GET("okhttp/issues")
    fun issuesList(
    ): Call<ArrayList<SquareIssuesDataClassItem>>

    @GET("comments")
    fun getCommentList(): Call<List<CommentsItem>>?

}