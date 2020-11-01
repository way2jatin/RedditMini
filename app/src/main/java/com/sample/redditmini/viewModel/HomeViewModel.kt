package com.sample.redditmini.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.redditmini.model.Topic
import com.sample.redditmini.repository.TopicRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val topicRepository = TopicRepository()

    val topicSuccessLiveData = topicRepository.topicSuccessLiveData
    val topicFailureLiveData = topicRepository.topicFailureLiveData
    val emptyStateLiveData = MutableLiveData<Boolean>()
    val allTopics = ArrayList<Topic>()

    fun getTopics(){
        viewModelScope.launch { topicRepository.getTopics() }
    }
}