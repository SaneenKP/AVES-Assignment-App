package com.saneen.avesassignmentapp.listeners

import com.saneen.avesassignmentapp.models.User

interface HomeItemClickListener {
    fun onImageClick(imageUrl : String? , desc : String?)
    fun onProfileClick(imageUrl: String? , userName : String? , location : String? , bio : String?)
}