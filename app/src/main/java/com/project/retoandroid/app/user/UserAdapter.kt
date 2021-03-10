package com.project.retoandroid.app.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.retoandroid.data.entity.User
import com.project.retoandroid.databinding.RowUserBinding

class UserAdapter(
    private val userViewModel: UserViewModel
) : ListAdapter<User, UserAdapter.ViewHolder>(User.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(userViewModel, user)
    }

    class ViewHolder private constructor(val binding: RowUserBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(userViewModel: UserViewModel, user: User) {
            binding.user = user
            binding.viewModel = userViewModel

            binding.executePendingBindings()
        }

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowUserBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }

        }

    }
}