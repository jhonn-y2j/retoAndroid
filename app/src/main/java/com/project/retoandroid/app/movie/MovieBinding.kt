package com.project.retoandroid.app.movie

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.project.retoandroid.data.entity.Movie
import com.project.retoandroid.data.service.ApiClient

@BindingAdapter("users")
fun bindUser(recyclerView: RecyclerView, movies: List<Movie>? = emptyList()) {
    movies ?: return
    (recyclerView.adapter as MovieAdapter).apply {
        submitList(movies)
    }
}

@BindingAdapter("image")
fun bindImage(image: ImageView, value: String) {
    image.load("${ApiClient.urlImage}$value")
}