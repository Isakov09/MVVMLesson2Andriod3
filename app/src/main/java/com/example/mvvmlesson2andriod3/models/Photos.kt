package com.example.mvvmlesson2andriod3.models

import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("photo")
    val photo: List<Photo>
)