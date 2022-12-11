package com.saneen.avesassignmentapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.saneen.avesassignmentapp.R
import com.saneen.avesassignmentapp.adapters.HomePageAdapter
import com.saneen.avesassignmentapp.databinding.ActivityMainBinding
import com.saneen.avesassignmentapp.utils.Constants
import com.saneen.avesassignmentapp.viewmodels.HomeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : HomeViewModel
    private lateinit var homeAdapter : HomePageAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        init()
    }

    private fun init(){
       viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
       viewModel.getData()


       binding.rvHome.apply {
           layoutManager = LinearLayoutManager(this@MainActivity)
           setHasFixedSize(true)
       }

       observeData()
    }

    private fun observeData(){

        viewModel.dataResponse.observe(this) {
            when (it.status) {

                Constants.Status.ERROR -> {
                }

                Constants.Status.SUCCESS -> {
                    homeAdapter = HomePageAdapter(it.data)
                    binding.rvHome.adapter = homeAdapter
                }

                Constants.Status.LOADING -> {
                    Log.d("saneen", "loading")
                }
            }
        }
    }
}