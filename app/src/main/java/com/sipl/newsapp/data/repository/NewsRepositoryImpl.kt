package com.sipl.newsapp.data.repository

import com.sipl.newsapp.data.remote.NewsAPI
import com.sipl.newsapp.data.remote.dto.Article
import com.sipl.newsapp.data.remote.dto.NewsData
import com.sipl.newsapp.domain.respository.NewsRepository
import javax.inject.Inject


class NewsRepositoryImpl @Inject constructor(private val newsAPI: NewsAPI) : NewsRepository {
    override suspend fun getNews(): List<Article> {
        return newsAPI.getNews().articles
    }
}