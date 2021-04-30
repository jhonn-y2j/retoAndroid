package com.project.retoandroid.data.repository

import com.project.retoandroid.data.entity.Movie
import com.project.retoandroid.data.service.ApiClient

class MovieRepository : MovieDataSource {

    companion object {
        private var INSTANCE: MovieRepository? = null
        @JvmStatic fun getInstance() = INSTANCE ?: MovieRepository().apply { INSTANCE = this }
    }

    lateinit var apiKey: String

    override suspend fun obtainMovies(): List<Movie> {
        val query = mapOf(
                Pair("page", "1"),
                Pair("api_key", apiKey)
        )
        val response = ApiClient.getTestApi().getMovies(query)
        if (!response.isSuccessful) {
            return emptyList()
        }

        return response.body()?.results ?: emptyList()
    }


}