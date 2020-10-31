package com.sample.redditmini.fragment

import android.os.Bundle
import android.view.View
import com.sample.redditmini.R
import com.sample.redditmini.databinding.FragmentViewTopicBinding
import com.sample.redditmini.util.BaseFragment

class ViewTopicFragment: BaseFragment<FragmentViewTopicBinding>() {

    override fun getLayoutParams(): Int = R.layout.fragment_view_topic

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.let {

        }
    }
}