package com.home.starter.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.home.starter.data.model.StoryDataModel
import com.home.starter.databinding.HolderStoryBinding
import com.home.starter.databinding.HolderVideoBinding

class AdapterStoriesAndVideos(
    private val items: List<Any>,
    private val callback: (Any) -> Unit
) : RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return when (viewType) {
            HomeViewType.Story.ordinal -> StoryViewHolder(HolderStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false), callback)
            else -> VideoViewHolder(HolderVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false), callback)
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binds(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is StoryDataModel -> HomeViewType.Story.ordinal
            else -> HomeViewType.Video.ordinal
        }
    }

    enum class HomeViewType {
        Story,
        Video
    }
}

