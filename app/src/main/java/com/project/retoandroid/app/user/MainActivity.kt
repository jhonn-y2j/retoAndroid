package com.project.retoandroid.app.user

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.project.retoandroid.R
import com.project.retoandroid.app.userDetail.UserDetailActivity
import com.project.retoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = UserViewModel.Factory(application)
        viewModel = ViewModelProvider(viewModelStore, factory).get(UserViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.rviUsers.adapter = UserAdapter(viewModel)

        initViewModel()

    }

    private fun initViewModel() {

        viewModel.apply {

            userSelected.observe(this@MainActivity, Observer {

                it?.let {

                    UserDetailActivity.startActivity(it, this@MainActivity)

                }

            })

        }

    }

}