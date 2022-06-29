package com.sipl.newsapp.presentation

sealed class Screen(val route: String) {
    object NewsListScreen: Screen("news_list_screen")

}
