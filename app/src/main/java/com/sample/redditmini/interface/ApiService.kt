package com.sample.redditmini.`interface`

import com.sample.redditmini.model.Topic
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("dceb4605-11b9-49df-be9e-5b0eae71215f")
    suspend fun getTopics(): Response<MutableList<Topic>>
}