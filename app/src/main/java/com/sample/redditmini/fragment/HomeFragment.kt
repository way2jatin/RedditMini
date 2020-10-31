package com.sample.redditmini.fragment

import android.os.Bundle
import android.view.View
import com.sample.redditmini.R
import com.sample.redditmini.databinding.FragmentHomeBinding
import com.sample.redditmini.util.BaseFragment
import com.sample.redditmini.viewModel.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    override fun getLayoutParams(): Int  = R.layout.fragment_home

    private val viewModel: HomeViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {

        }

    }
}