package com.home.starter.domain

import com.home.starter.createStories
import com.home.starter.domain.input.EuroSportRepository
import com.home.starter.domain.usecase.StoriesUseCase
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.openMocks

class StoriesUseCaseTests {

    @Mock
    lateinit var repository: EuroSportRepository

    private lateinit var useCase: StoriesUseCase

    @Before
    fun setup() {
        openMocks(this)
        useCase = StoriesUseCase(repository)
    }

    @Test
    fun `give data source available when required it should get stories sorted by date`() = runBlocking {
        `when`(repository.fetchStories()).thenReturn(createStories())

        val result = useCase.getStories()

        assertNotNull(result)
        assertEquals("1588222335.007", result.first().date)
    }

}
