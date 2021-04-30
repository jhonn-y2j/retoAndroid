package com.project.retoandroid.app.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.retoandroid.data.entity.Movie
import com.project.retoandroid.databinding.RowMovieBinding

class MovieAdapter(
    private val movieViewModel: MovieViewModel
) : ListAdapter<Movie, MovieAdapter.ViewHolder>(Movie.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movieViewModel, movie)
    }

    class ViewHolder private constructor(val binding: RowMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movieViewModel: MovieViewModel, movie: Movie) {
            binding.movie = movie
            binding.viewModel = movieViewModel

            binding.executePendingBindings()
        }

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowMovieBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }

        }

    }
}