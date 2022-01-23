package com.home.starter.presentation.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.home.starter.domain.usecase.StoriesUseCase
import com.home.starter.domain.usecase.VideosUseCase
import com.home.starter.presentation.mapper.StoriesAndVideosMixer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val videosUseCase: VideosUseCase,
    private val storyUseCase: StoriesUseCase,
    private val mapper: StoriesAndVideosMixer
) : ViewModel() {
    private val errorHandler = CoroutineExceptionHandler { _, _ ->
        state.tryEmit(State.Failure)
    }

    private val _state = MutableSharedFlow<State>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val state get() = _state

    sealed class State {
        object Failure : State()
        data class Success(val items: List<Any>) : State()
        object Empty : State()
    }

    fun fetch() {
        viewModelScope.launch(errorHandler) {
            val stories = storyUseCase.getStories()
            val videos = videosUseCase.getVideos()
            state.tryEmit(State.Success(mapper.invoke(stories, videos)))
        }
    }
}