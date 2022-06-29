package com.sipl.newsapp.data.remote.dto

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)