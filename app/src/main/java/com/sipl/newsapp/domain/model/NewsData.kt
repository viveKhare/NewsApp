package com.sipl.newsapp.domain.model

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)