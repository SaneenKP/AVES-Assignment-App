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
        const val USER_NAME_INTENT = "user_name_intent"
        const val USER_BIO_INTENT = "user_bio_intent"
        const val USER_LOCATION_INTENT = "user_location_intent"
        const val USER_PROFILE_IMAGE_URL_INTENT = "user_profile_image_url"
    }

}