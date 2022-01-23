package com.home.starter.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DataResponse(
    val videos: List<VideoDataModel>,
    val stories: List<StoryDataModel>
)

@Parcelize
data class VideoDataModel(
    val id: Long?,
    val title: String?,
    @SerializedName("thumb")
    val imageUrl: String?,
    val date: String?,
    val sport: SportModel?,
    val url: String?,
    val views: Long?
) : Parcelable

@Parcelize
data class SportModel(
    val id: String,
    val name: String
) : Parcelable

@Parcelize
data class StoryDataModel(
    val id: Long?,
    val title: String?,
    val teaser: String?,
    val image: String?,
    val date: String?,
    val author: String?,
    val sport: SportModel?
) : Parcelable