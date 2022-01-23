package com.home.starter

import com.home.starter.data.model.StoryDataModel
import com.home.starter.data.model.VideoDataModel

fun createVideos() = listOf(
    VideoDataModel(
        id = 1,
        title = "title",
        imageUrl = "url",
        //28/04/2020 22:07:25
        date = "1588104445.007",
        sport = null,
        views = 0,
        url = "url"
    ),
    VideoDataModel(
        id = 0,
        title = "title",
        imageUrl = "url",
        //30/04/2020 07:27:25
        date = "1588224445.007",
        sport = null,
        views = 0,
        url = "url"
    ),
    VideoDataModel(
        id = 2,
        title = "title",
        imageUrl = "url",
        //26/02/2017 13:50:45
        date = "1488113445.007",
        sport = null,
        views = 0,
        url = "url"
    )
)

fun createStories(): List<StoryDataModel> {
    return listOf(
        StoryDataModel(
            id = 1,
            title = "title",
            teaser = "teaser",
            image = "url",
            // 29/04/2020 00:13:49
            date = "1588112029.433",
            author = "",
            sport = null
        ),
        StoryDataModel(
            id = 1,
            title = "title",
            teaser = "teaser",
            image = "url",
            // 29/04/2020 15:11:05
            date = "1588165865.817",
            author = "",
            sport = null
        ),
        StoryDataModel(
            id = 0,
            title = "title",
            teaser = "teaser",
            image = "url",
            // 30/04/2020 06:52:15
            date = "1588222335.007",
            author = "",
            sport = null
        )
    )
}
