package com.example.newkotlindagger.apiService

import com.example.newkotlindagger.pojo.NewsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v2/top-headlines?country=eg&apiKey=63b1f94dad044add871d1e319c630265")
    suspend fun getData(): Response<List<NewsModel>>

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
    }
}

