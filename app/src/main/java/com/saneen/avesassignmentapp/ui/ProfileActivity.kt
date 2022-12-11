package com.saneen.avesassignmentapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.saneen.avesassignmentapp.R
import com.saneen.avesassignmentapp.adapters.imageFromImagePath
import com.saneen.avesassignmentapp.databinding.ActivityProfileBinding
import com.saneen.avesassignmentapp.models.User
import com.saneen.avesassignmentapp.utils.Constants

class ProfileActivity : AppCompatActivity() {

    private var profileImageUrl : String? = ""
    private var location : String? = ""
    private var bio :  String? = ""
    private var name : String? = ""
    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_profile)

        handleIntent()
        bindData()
    }

    private fun handleIntent(){
        profileImageUrl = intent.getStringExtra(Constants.USER_PROFILE_IMAGE_URL_INTENT)
        location = intent.getStringExtra(Constants.USER_LOCATION_INTENT)
        bio = intent.getStringExtra(Constants.USER_BIO_INTENT)
        name = intent.getStringExtra(Constants.USER_NAME_INTENT)
    }

    private fun bindData(){
        binding.profileImage.imageFromImagePath(profileImageUrl)
        if (name == null) "No name available for the user" else binding.name.text = name
        if (location == null) "No location available for the user" else binding.location.text =location
        if (bio == null) "No bio available for the user" else binding.bio.text = bio
    }
}