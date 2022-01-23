package com.home.starter.presentation.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.home.starter.databinding.FragmentVideoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : Fragment() {

    private lateinit var viewBinding: FragmentVideoBinding
    private lateinit var player: ExoPlayer
    private val args: VideoFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentVideoBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        player = ExoPlayer.Builder(requireContext()).build()

        viewBinding.apply {
            playerView.player = player
            val mediaItem: MediaItem = MediaItem.fromUri(args.videoArgument.url.orEmpty())
            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()
        }
    }

    override fun onDestroy() {
        player.stop()
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        viewBinding.apply {
            setPlayerConfig(getRequiredSize(newConfig))
        }
    }

    private fun getRequiredSize(newConfig: Configuration) = when (newConfig.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> ViewGroup.LayoutParams.MATCH_PARENT
        else -> 800
    }

    private fun FragmentVideoBinding.setPlayerConfig(height: Int) {
        val params = playerView.layoutParams as LinearLayout.LayoutParams
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = height
        playerView.layoutParams = params
    }


}
