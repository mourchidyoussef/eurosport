package com.home.starter.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.home.starter.databinding.FragmentStoryBinding
import com.home.starter.presentation.extension.prettyAuthorInfo

class StoryFragment : Fragment() {

    private lateinit var viewBinding: FragmentStoryBinding
    private val args: StoryFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentStoryBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
        initListeners()
    }

    private fun setView() {
        viewBinding.apply {
            val story = args.storyArgument
            recipeImage.load(story.image)
            textLabel.text = story.sport?.name.orEmpty()
            textTitle.text = story.title
            textAuthor.text = story.prettyAuthorInfo()
            textTeaser.text = story.teaser
        }
    }

    private fun initListeners() {
        viewBinding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}