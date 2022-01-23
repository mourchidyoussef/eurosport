package com.home.starter.presentation

import com.home.starter.createStories
import com.home.starter.createVideos
import com.home.starter.data.model.StoryDataModel
import com.home.starter.data.model.VideoDataModel
import com.home.starter.presentation.mapper.StoriesAndVideosMixer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class StoriesAndVideosMixerTests {

    private val mixer = StoriesAndVideosMixer()

    @Test
    fun `test mixed stories an videos for two lists of single element`() {
        val videos = listOf(
            VideoDataModel(
                id = 1,
                title = "title",
                imageUrl = "url",
                //28/04/2020 22:07:25
                date = "1588104445.007",
                sport = null,
                views = 0
            )
        )

        val stories = listOf(
            StoryDataModel(
                id = 1,
                title = "title",
                teaser = "teaser",
                image = "url",
                // 29/04/2020 00:13:49
                date = "1588112029.433",
                author = "",
                sport = null
            )
        )

        val result = mixer.invoke(stories, videos)

        assertEquals(2, result.size)
        assertTrue(result.first() is StoryDataModel)
        assertTrue(result.last() is VideoDataModel)
    }

    @Test
    fun `test mixed stories an videos for two lists of many elements of same size`() {
        val videos = createVideos()
        val stories = createStories()

        val result = mixer.invoke(stories, videos)

        assertEquals(6, result.size)
    }

    @Test
    fun `test mixed stories an videos for two lists of many elements of different size`() {
        val videos = listOf(
            VideoDataModel(
                id = 1,
                title = "title",
                imageUrl = "url",
                //28/04/2020 22:07:25
                date = "1588104445.007",
                sport = null,
                views = 0
            )
        )

        val stories = listOf(
            StoryDataModel(
                id = 0,
                title = "title",
                teaser = "teaser",
                image = "url",
                // 30/04/2020 06:52:15
                date = "1588222335.007",
                author = "",
                sport = null
            ),
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
                id = 5,
                title = "title",
                teaser = "teaser",
                image = "url",
                // 29/04/2020 00:13:49
                date = "1588112029.433",
                author = "",
                sport = null
            )
        )


        val result = mixer.invoke(stories, videos)

        assertEquals(4, result.size)
        assertTrue(result.first() is StoryDataModel)
        assertTrue(result.last() is StoryDataModel)
        assertTrue(result[1] is VideoDataModel)
    }

}