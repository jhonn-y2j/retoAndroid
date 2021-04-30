package com.project.retoandroid.app.movieDetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.retoandroid.data.entity.Movie

class MovieDetailsViewModel(
    application: Application,
    movie: Movie,
): AndroidViewModel(application) {

    val movieData = movie

    class Factory(
        private val application: Application,
        private val movie: Movie
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(MovieDetailsViewModel::class.java) ->
                        MovieDetailsViewModel(
                            application,
                            movie
                        )
                    else -> throw IllegalArgumentException("Unknown ViewModel")
                }
            } as T
    }

}