package com.saneen.avesassignmentapp.models

import com.google.gson.annotations.SerializedName

class ProfileImage (
    @SerializedName("small"  ) var small  : String? = null,
    @SerializedName("medium" ) var medium : String? = null,
    @SerializedName("large"  ) var large  : String? = null
)