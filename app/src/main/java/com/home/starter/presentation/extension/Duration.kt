package com.home.starter.presentation.extension

import com.home.starter.data.model.StoryDataModel
import com.home.starter.data.model.VideoDataModel
import org.joda.time.DateTime
import org.joda.time.Duration

fun StoryDataModel.prettyAuthorInfo(): String {
    val dateLong = (date?.toFloat() ?: 0).toLong() * 1000L
    val postDate = DateTime(dateLong)
    val today = DateTime()
    val duration = Duration(postDate, today)
    return "$author - ${duration.standardDays} j ago"
}

fun VideoDataModel.prettyViews() = "${views.toString()} views"
