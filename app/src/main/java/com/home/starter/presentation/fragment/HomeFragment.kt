package com.home.starter.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.home.starter.R
import com.home.starter.data.model.StoryDataModel
import com.home.starter.data.model.VideoDataModel
import com.home.starter.databinding.FragmentHomeBinding
import com.home.starter.presentation.adapter.AdapterStoriesAndVideos
import com.home.starter.presentation.model.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    state.collectLatest(::renderState)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetch()
    }

    private fun renderState(state: HomeViewModel.State) {
        when (state) {
            is HomeViewModel.State.Success -> initAdapter(state.items)
            is HomeViewModel.State.Failure -> showError()
        }
    }

    private fun showError() {
        Snackbar.make(viewBinding.root, getString(R.string.error_found), Snackbar.LENGTH_SHORT).show()
    }

    private fun initAdapter(list: List<Any>) {
        viewBinding.recyclerStoriesVideos.apply {
            adapter = AdapterStoriesAndVideos(list) { itemClicked ->
                findNavController().navigate(getDirection(itemClicked))
            }
            layoutManager = LinearLayoutManager(viewBinding.root.context)
        }
    }

    private fun getDirection(itemClicked: Any): NavDirections = when (itemClicked) {
        is StoryDataModel -> HomeFragmentDirections.navigateToStoryFragment(itemClicked)
        is VideoDataModel -> HomeFragmentDirections.navigateToVideoFragment(itemClicked)
        else -> throw Throwable("not valid item")
    }
}