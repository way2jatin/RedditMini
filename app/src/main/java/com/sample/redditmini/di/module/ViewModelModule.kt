package com.sample.redditmini.di.module

import com.sample.redditmini.repository.TopicRepository
import com.sample.redditmini.viewModel.HomeViewModel
import com.sample.redditmini.viewModel.CreateTopicViewModel
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