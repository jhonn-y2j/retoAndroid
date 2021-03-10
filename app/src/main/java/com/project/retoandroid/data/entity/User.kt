package com.project.retoandroid.data.entity

import androidx.recyclerview.widget.DiffUtil
import java.io.Serializable

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val website: String,
    val address: Address,
    val company: Company
): Serializable {

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {

            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }

    }

}