package com.project.retoandroid.app.userDetail

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.project.retoandroid.R
import com.project.retoandroid.data.entity.User
import com.project.retoandroid.databinding.ActivityUserDetailBinding

class UserDetailActivity: AppCompatActivity() {

    private lateinit var user: User
    private lateinit var binding: ActivityUserDetailBinding

    companion object {

        fun startActivity(user: User, activity: Activity) {
            val intent = Intent(activity.applicationContext, UserDetailActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("user", user)
            intent.putExtras(bundle)
            activity.startActivity(intent)
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        intent?.extras?.let {

            user = it.getSerializable("user") as User

            binding.textDetail.text = "Nombre: ${user.name}\n" +
                    "Correo Electrónico: ${user.email}\n" +
                    "Teléfono: ${user.phone}"

        }

    }

}