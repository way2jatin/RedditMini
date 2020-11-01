package com.sample.redditmini.`interface`

import com.sample.redditmini.model.Topic
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("3db3ed73-5a62-4d0e-b97e-188930c4d8c8")
    suspend fun getTopics(): Response<MutableList<Topic>>
}