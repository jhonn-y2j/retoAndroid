package com.project.retoandroid.app.movie

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.project.retoandroid.R
import com.project.retoandroid.app.movieDetail.MovieDetailsActivity
import com.project.retoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MovieViewModel

    companion object {

        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity.applicationContext, MainActivity::class.java))
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = MovieViewModel.Factory(application)
        viewModel = ViewModelProvider(viewModelStore, factory).get(MovieViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.rviMovies.adapter = MovieAdapter(viewModel)

        supportActionBar?.title = "Peliculas"

        initViewModel()

    }

    private fun initViewModel() {

        viewModel.apply {

            movieSelected.observe(this@MainActivity, {

                it?.let {

                    MovieDetailsActivity.startActivity(it, this@MainActivity)

                }

            })

        }

    }

}