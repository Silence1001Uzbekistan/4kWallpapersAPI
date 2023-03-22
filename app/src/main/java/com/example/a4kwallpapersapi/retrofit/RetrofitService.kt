package com.example.introductionretrofit.retrofit

import com.example.a4kwallpapersapi.models.Urls
import com.example.a4kwallpapersapi.modelsThree.UsersItem
import com.example.a4kwallpapersapi.modelsTwo.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("marvel")
    fun getMovie(): Call<List<Movie>>

}