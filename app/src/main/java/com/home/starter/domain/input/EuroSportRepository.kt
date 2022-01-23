package com.home.starter.domain.input

import com.home.starter.data.model.StoryDataModel
import com.home.starter.data.model.VideoDataModel

interface EuroSportRepository {

    suspend fun fetchVideos(): List<VideoDataModel>

    suspend fun fetchStories(): List<StoryDataModel>

}