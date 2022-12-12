package com.example.gamessearchwithcompose.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageXX(
    @SerializedName("icon_url")
    val iconUrl: String? = null,
    @SerializedName("medium_url")
    val mediumUrl: String? = null,
    @SerializedName("original")
    val original: String? = null,
    @SerializedName("screen_url")
    val screenUrl: String? = null,
    @SerializedName("small_url")
    val smallUrl: String? = null,
    @SerializedName("super_url")
    val superUrl: String? = null,
    @SerializedName("tags")
    val tags: String? = null,
    @SerializedName("thumb_url")
    val thumbUrl: String? = null,
    @SerializedName("tiny_url")
    val tinyUrl: String? = null
) : Parcelable