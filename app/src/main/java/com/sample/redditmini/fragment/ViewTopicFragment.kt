package com.sample.redditmini.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sample.redditmini.R
import com.sample.redditmini.databinding.FragmentViewTopicBinding
import com.sample.redditmini.model.Topic
import com.sample.redditmini.util.BaseFragment

class ViewTopicFragment: BaseFragment<FragmentViewTopicBinding>() {

    override fun getLayoutParams(): Int = R.layout.fragment_view_topic
    lateinit var topic:Topic

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.title =
            getString(R.string.view_topic)

        arguments?.let {
            topic = it.getParcelable<Topic>("topic") as Topic
        }

        binding?.let {
            it.topic = topic
            it.lifecycleOwner = this

        }
    }
}