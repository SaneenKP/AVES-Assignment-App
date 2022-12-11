package com.saneen.avesassignmentapp.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.saneen.avesassignmentapp.R

@BindingAdapter("imageFromPath")
fun ImageView.imageFromImagePath(imageUrl : String?){
    Glide.with(this.context)
        .load(imageUrl)
        .placeholder(R.drawable.movie_image_placeholder)
        .into(this)
}
