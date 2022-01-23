package com.home.starter.domain.usecase

import com.home.starter.data.model.StoryDataModel
import com.home.starter.domain.input.EuroSportRepository
import javax.inject.Inject

class StoriesUseCase @Inject constructor(
    private val repository: EuroSportRepository
) {

    suspend fun getStories(): List<StoryDataModel> {
        return repository.fetchStories().sortedByDescending { it.date }
    }

}