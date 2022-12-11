package com.saneen.avesassignmentapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.saneen.avesassignmentapp.R
import com.saneen.avesassignmentapp.adapters.imageFromImagePath
import com.saneen.avesassignmentapp.databinding.ActivityImageBinding
import com.saneen.avesassignmentapp.utils.Constants

class ImageActivity : AppCompatActivity() {

    private var imageUrl : String? = ""
    private var description : String? = ""
    lateinit var binding : ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_image)

        handleIntent()
        setData()
    }

    private fun handleIntent(){
        imageUrl = intent.getStringExtra(Constants.IMAGE_URL_INTENT)
        description = intent.getStringExtra(Constants.IMAGE_DESCRIPTION_INTENT)
    }

    private fun setData(){
        binding.ivMainImage.imageFromImagePath(imageUrl)

        if (description.isNullOrEmpty()){
            binding.tvDesc.text = "No description Available"
        }else{
            binding.tvDesc.text = description
        }
    }

}