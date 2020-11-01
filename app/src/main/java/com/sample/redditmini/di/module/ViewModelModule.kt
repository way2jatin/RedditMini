package com.sample.redditmini.di.module

import com.sample.redditmini.viewModel.CreateTopicViewModel
import com.sample.redditmini.viewModel.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel()
    }

    viewModel {
        CreateTopicViewModel()
    }
}