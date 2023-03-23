package com.example.introductionretrofit.retrofit

import com.example.a4kwallpapersapi.models.Urls
import com.example.a4kwallpapersapi.models.WallpapersItem
import com.example.a4kwallpapersapi.modelsThree.UsersItem
import com.example.a4kwallpapersapi.modelsTwo.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("photos")
    fun getMovie(
        @Query("query") query: String,@Query("client_id") client:String
    ): Call<List<WallpapersItem>>

}