package com.home.starter.presentation.mapper

import com.home.starter.data.model.StoryDataModel
import com.home.starter.data.model.VideoDataModel
import javax.inject.Inject

class StoriesAndVideosMixer @Inject constructor() : (List<StoryDataModel>, List<VideoDataModel>) -> (List<Any>) {

    override fun invoke(stories: List<StoryDataModel>, videos: List<VideoDataModel>): List<Any> {
        return (stories.zip(videos).flatMap { pair -> listOf(pair.first, pair.second) } + stories + videos).distinct()
    }
}