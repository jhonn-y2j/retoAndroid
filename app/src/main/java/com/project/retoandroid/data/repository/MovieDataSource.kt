package com.project.retoandroid.data.repository

import com.project.retoandroid.data.entity.Movie

interface MovieDataSource {

    suspend fun obtainMovies(): List<Movie>

}