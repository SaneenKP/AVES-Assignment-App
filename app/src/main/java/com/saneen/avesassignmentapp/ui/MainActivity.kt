package com.saneen.avesassignmentapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.saneen.avesassignmentapp.R
import com.saneen.avesassignmentapp.adapters.HomePageAdapter
import com.saneen.avesassignmentapp.databinding.ActivityMainBinding
import com.saneen.avesassignmentapp.listeners.HomeItemClickListener
import com.saneen.avesassignmentapp.models.User
import com.saneen.avesassignmentapp.utils.Constants
import com.saneen.avesassignmentapp.viewmodels.HomeViewModel

class MainActivity : AppCompatActivity() , HomeItemClickListener {

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
                    homeAdapter = HomePageAdapter(it.data , this)
                    binding.rvHome.adapter = homeAdapter
                }

                Constants.Status.LOADING -> {
                }
            }
        }
    }

    override fun onImageClick(imageUrl: String?, desc: String?) {
        val intent = Intent(this , ImageActivity::class.java)
        intent.putExtra(Constants.IMAGE_URL_INTENT , imageUrl)
        intent.putExtra(Constants.IMAGE_DESCRIPTION_INTENT , desc)
        startActivity(intent)
    }

    override fun onProfileClick(
        imageUrl: String?,
        userName: String?,
        location: String?,
        bio: String?
    ) {
        val intent = Intent(this , ProfileActivity::class.java)
        intent.putExtra(Constants.USER_PROFILE_IMAGE_URL_INTENT , imageUrl)
        intent.putExtra(Constants.USER_NAME_INTENT , userName)
        intent.putExtra(Constants.USER_LOCATION_INTENT , location)
        intent.putExtra(Constants.USER_BIO_INTENT , bio)
        startActivity(intent)
    }
}