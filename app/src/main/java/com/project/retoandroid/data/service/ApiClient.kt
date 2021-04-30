package com.project.retoandroid.data.service

import com.project.retoandroid.utils.RetrofitUtil
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val urlMovie = "https://api.themoviedb.org"
    const val urlImage = "https://image.tmdb.org/t/p/w500/"

    @JvmStatic fun getTestApi() : TestApi =
        Retrofit.Builder()
            .baseUrl(urlMovie)
            .client(RetrofitUtil.getBasicClientInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(TestApi::class.java)

}