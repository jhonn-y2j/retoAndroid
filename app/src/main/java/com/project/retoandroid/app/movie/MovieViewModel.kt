package com.project.retoandroid.app.movie

import android.app.Application
import androidx.lifecycle.*
import com.project.retoandroid.R
import com.project.retoandroid.app.Injection
import com.project.retoandroid.data.entity.Movie
import kotlinx.coroutines.launch

class MovieViewModel(
    application: Application
): AndroidViewModel(application) {

    private val movieRepository = Injection.provideMovieRepository()

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    val movieSelected = MutableLiveData<Movie>()
    val context = application.applicationContext?.let {
        movieRepository.apiKey = it.getString(R.string.api_key_movie)
    }

    init {

        obtainMovies()

    }

    private fun obtainMovies() {

        viewModelScope.launch {

            try {

                val response = movieRepository.obtainMovies()
                _movies.value = response

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }

    fun onMovie(movie: Movie) {
        movieSelected.value = movie
    }

    class Factory(
        private val application: Application
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(MovieViewModel::class.java) ->
                        MovieViewModel(
                            application,
                        )
                    else -> throw IllegalArgumentException("Unknown ViewModel")
                }
            } as T
    }

}