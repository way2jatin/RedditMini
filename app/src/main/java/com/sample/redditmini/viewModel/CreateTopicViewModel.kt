package com.sample.redditmini.viewModel

import androidx.lifecycle.ViewModel
import com.sample.redditmini.model.Topic

class CreateTopicViewModel: ViewModel() {

    var title :String? = null
    var content: String? = null

    fun saveTopic(position: Int): Topic {
        return Topic(position,title,content,15,10)
    }
}