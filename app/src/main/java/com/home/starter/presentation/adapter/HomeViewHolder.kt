package com.home.starter.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.home.starter.data.model.StoryDataModel
import com.home.starter.data.model.VideoDataModel
import com.home.starter.databinding.HolderStoryBinding
import com.home.starter.databinding.HolderVideoBinding
import com.home.starter.presentation.extension.prettyAuthorInfo
import com.home.starter.presentation.extension.prettyViews

abstract class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun binds(item: Any)
}

class StoryViewHolder(
    private val viewBinding: HolderStoryBinding,
    private val callback: (Any) -> Unit
) : HomeViewHolder(viewBinding.root) {

    override fun binds(item: Any) {
        item as StoryDataModel
        setUi(item)
        setListeners(item)
    }

    private fun setListeners(item: Any) {
        viewBinding.holderStory.setOnClickListener {
            callback(item)
        }
    }

    private fun setUi(item: StoryDataModel) {
        viewBinding.apply {
            imageStory.load(item.image)
            textLabel.text = item.sport?.name
            textTitle.text = item.title
            textAuthor.text = item.prettyAuthorInfo()
        }
    }
}

class VideoViewHolder(
    private val viewBinding: HolderVideoBinding,
    private val callback: (Any) -> Unit
) : HomeViewHolder(viewBinding.root) {

    override fun binds(item: Any) {
        item as VideoDataModel
        setUi(item)
        setListeners(item)
    }

    private fun setListeners(item: Any) {
        viewBinding.holderVideo.setOnClickListener {
            callback(item)
        }
    }

    private fun setUi(item: VideoDataModel) {
        viewBinding.apply {
            imageVideo.load(item.imageUrl)
            textLabel.text = item.sport?.name
            textTitle.text = item.title
            textViews.text = item.prettyViews()
        }
    }

}