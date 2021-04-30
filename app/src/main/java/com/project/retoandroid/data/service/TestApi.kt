package com.project.retoandroid.data.service

import com.project.retoandroid.data.entity.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface TestApi {

    @GET("3/movie/upcoming")
    suspend fun getMovies(@QueryMap(encoded = true) query: Map<String, String>): Response<MovieResponse>

}