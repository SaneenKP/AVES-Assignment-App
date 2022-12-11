package com.saneen.avesassignmentapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.saneen.avesassignmentapp.R
import com.saneen.avesassignmentapp.utils.Constants
import com.saneen.avesassignmentapp.viewmodels.HomeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
       viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
       viewModel.getData()

       observeData()
    }

    private fun observeData(){

        viewModel.dataResponse.observe(this) {
            when (it.status) {

                Constants.Status.ERROR -> {
                    Log.d("saneen", "error = ${it.message}")
                }

                Constants.Status.SUCCESS -> {
                    Log.d("saneen", it.data.toString())
                }

                Constants.Status.LOADING -> {
                    Log.d("saneen", "loading")
                }
            }
        }
    }
}