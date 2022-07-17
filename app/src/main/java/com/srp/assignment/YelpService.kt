package edu.stanford.dstratak.yelp

import YelpSearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface YelpService {

    @GET("businesses/search")
    fun searchRestaurants(
        @Header("Authorization") authHeader: String,
        @Query("term") searchTerm: String,
        @Query("location") location: String,
        @Query("radius") radius: Int,
        @Query("sort_by") distance: String,
        @Query("limit") limit: Int
    ): Call<YelpSearchResult>


}