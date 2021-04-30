package com.project.retoandroid.app.movieDetail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.project.retoandroid.R
import com.project.retoandroid.data.entity.Movie
import com.project.retoandroid.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var viewModel: MovieDetailsViewModel

    companion object {

        fun startActivity(movie: Movie, activity: Activity) {
            val intent = Intent(activity.applicationContext, MovieDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("movie", movie)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent?.extras?.let {

            val movie = it.getSerializable("movie") as Movie
            val factory = MovieDetailsViewModel.Factory(application, movie)
            viewModel = ViewModelProvider(viewModelStore, factory).get(MovieDetailsViewModel::class.java)

            binding.viewModel = viewModel

        }

    }
}