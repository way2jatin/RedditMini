package com.sample.redditmini.repository

import androidx.lifecycle.MutableLiveData
import com.sample.redditmini.RetrofitManager
import com.sample.redditmini.model.Topic
import java.lang.Exception

class TopicRepository {

    private val apiService = RetrofitManager.apiService

    val topicSuccessLiveData = MutableLiveData<MutableList<Topic>>()
    val topicFailureLiveData = MutableLiveData<Boolean>()

    suspend fun getTopics() {
        try{
            val response = apiService.getTopics()

            if (response.isSuccessful){
                topicSuccessLiveData.postValue(response.body())
            }
            else{
                topicFailureLiveData.postValue(true)

            }

        }catch (e:Exception){
            topicFailureLiveData.postValue(true)
        }
    }


}