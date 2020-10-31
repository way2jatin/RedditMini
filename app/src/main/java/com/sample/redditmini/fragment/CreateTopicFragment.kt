package com.sample.redditmini.fragment

import android.os.Bundle
import android.view.View
import com.sample.redditmini.R
import com.sample.redditmini.databinding.FragmentCreateTopicBinding
import com.sample.redditmini.util.BaseFragment
import com.sample.redditmini.viewModel.CreateTopicViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CreateTopicFragment: BaseFragment<FragmentCreateTopicBinding>() {
    override fun getLayoutParams(): Int = R.layout.fragment_create_topic

    private val viewModel: CreateTopicViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {

        }
    }
}