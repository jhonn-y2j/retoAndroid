package com.project.retoandroid.app.user

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.retoandroid.data.entity.User

@BindingAdapter("users")
fun bindUser(recyclerView: RecyclerView, users: List<User>? = emptyList()) {
    users ?: return
    (recyclerView.adapter as UserAdapter).apply {
        submitList(users)
    }
}