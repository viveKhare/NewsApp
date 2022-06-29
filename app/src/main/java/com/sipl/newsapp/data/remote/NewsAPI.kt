package com.sipl.newsapp.data.remote

import com.sipl.newsapp.data.remote.dto.NewsData
import retrofit2.http.GET

interface NewsAPI {
    @GET("everything?q=latest&sortBy=popularity&apiKey=53a4faebbbde406db6c1d527671888b2")
    suspend fun getNews(): NewsData
}