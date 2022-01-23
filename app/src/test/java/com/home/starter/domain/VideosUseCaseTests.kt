package com.home.starter.domain

import com.home.starter.createVideos
import com.home.starter.domain.input.EuroSportRepository
import com.home.starter.domain.usecase.VideosUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.openMocks

class VideosUseCaseTests {

    @Mock
    lateinit var repository: EuroSportRepository

    private lateinit var useCase: VideosUseCase

    @Before
    fun setup() {
        openMocks(this)
        useCase = VideosUseCase(repository)
    }


    @Test
    fun `give data source available when required it should get videos sorted by date`() = runBlocking {
        `when`(repository.fetchVideos()).thenReturn(createVideos())

        val result = useCase.getVideos()

        assertNotNull(result)
        assertEquals("1588224445.007", result.first().date)
    }

}
