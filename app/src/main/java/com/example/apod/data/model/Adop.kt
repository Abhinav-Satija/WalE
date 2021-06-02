package com.mindorks.framework.mvvm.data.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Adop(
    @PrimaryKey
    @NonNull
    @SerializedName("date")
    val date: String ,
    @SerializedName("explanation")
    val explanation: String = "",
    @SerializedName("hdurl")
    val hdurl: String = "",
    @SerializedName("media_type")
    val media_type: String = "",
    @SerializedName("service_version")
    val service_version: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = ""
)