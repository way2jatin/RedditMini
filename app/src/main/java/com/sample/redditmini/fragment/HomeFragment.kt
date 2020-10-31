package com.sample.redditmini.fragment

import android.os.Bundle
import android.view.View
import com.sample.redditmini.R
import com.sample.redditmini.databinding.FragmentHomeBinding
import com.sample.redditmini.util.BaseFragment

class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    override fun getLayoutParams(): Int  = R.layout.fragment_home


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let {

        }

    }
}