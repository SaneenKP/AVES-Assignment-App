package com.saneen.avesassignmentapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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
        supportActionBar?.hide()
        window.statusBarColor = resources.getColor(R.color.black)
        findViewById<TextView>(R.id.tv_toolbar).apply {
            text = context.resources.getString(R.string.screen2)
            setTextColor(context.resources.getColor(R.color.white))
        }
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
        if (name == null) resources.getString(R.string.name_unavailable) else binding.name.text = name
        if (location == null) resources.getString(R.string.location_unavailable) else binding.location.text =location
        if (bio == null) resources.getString(R.string.bio_unavailable) else binding.bio.text = bio
    }
}