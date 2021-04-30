package com.project.retoandroid.app

import com.project.retoandroid.data.repository.LoginRepository
import com.project.retoandroid.data.repository.MovieRepository

object Injection {

    fun provideMovieRepository(): MovieRepository {
        return MovieRepository.getInstance()
    }

    fun provideLoginRepository() = LoginRepository.getInstance()

}