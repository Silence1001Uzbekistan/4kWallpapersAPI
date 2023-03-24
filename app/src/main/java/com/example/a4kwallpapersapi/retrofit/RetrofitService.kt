package com.example.introductionretrofit.retrofit

import com.example.a4kwallpapersapi.models.Wallpapers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("search/photos")
    fun getMovie(
        @Query("query") query: String,@Query("client_id") client:String
    ): Call<Wallpapers>

}