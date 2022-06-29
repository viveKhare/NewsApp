package com.sipl.newsapp.presentation.news_list

import com.sipl.newsapp.data.remote.dto.Article

class NewsListState (
    val isLoading: Boolean = false,
    val coins: List<Article> = emptyList(),
    val error: String = ""
)