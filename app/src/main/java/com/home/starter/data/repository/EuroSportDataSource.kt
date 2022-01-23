package com.home.starter.data.repository

import com.home.starter.data.model.StoryDataModel
import com.home.starter.data.model.VideoDataModel
import com.home.starter.data.service.EuroSportService
import com.home.starter.domain.input.EuroSportRepository
import javax.inject.Inject

class EuroSportDataSource @Inject constructor(
    private val service: EuroSportService
) : EuroSportRepository {

    override suspend fun fetchVideos(): List<VideoDataModel> {
        return service.fetch().body()?.videos ?: emptyList()
    }

    override suspend fun fetchStories(): List<StoryDataModel> {
        return service.fetch().body()?.stories ?: emptyList()
    }
}