package com.saneen.avesassignmentapp.utils

class Constants {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object{

        //Intents
        const val IMAGE_URL_INTENT = "image_url_intent"
        const val IMAGE_DESCRIPTION_INTENT = "image_description_intent"
    }

}