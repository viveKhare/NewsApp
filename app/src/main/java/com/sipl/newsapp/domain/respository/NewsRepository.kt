package com.sipl.newsapp.domain.respository

import com.sipl.newsapp.data.remote.dto.Article
import com.sipl.newsapp.data.remote.dto.NewsData

interface NewsRepository {

    suspend fun getNews(): List<Article>
}