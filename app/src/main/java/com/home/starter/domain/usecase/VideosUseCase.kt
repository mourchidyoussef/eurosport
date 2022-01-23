package com.home.starter.domain.usecase

import com.home.starter.data.model.VideoDataModel
import com.home.starter.domain.input.EuroSportRepository
import javax.inject.Inject

class VideosUseCase @Inject constructor(
    private val repository: EuroSportRepository
) {

    suspend fun getVideos(): List<VideoDataModel> {
        return repository.fetchVideos().sortedByDescending { it.date }
    }

}