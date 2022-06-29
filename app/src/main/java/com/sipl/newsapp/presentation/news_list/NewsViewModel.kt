package com.sipl.newsapp.presentation.news_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sipl.newsapp.common.Resource
import com.sipl.newsapp.domain.use_cases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val getNewsUseCase: GetNewsUseCase): ViewModel(){

    private val _state = mutableStateOf(NewsListState())
    val state: State<NewsListState> = _state
    init {
        getNews()
    }

    private fun getNews() {
        getNewsUseCase().onEach {result->
            when (result) {
                is Resource.Success -> {
                    _state.value = NewsListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = NewsListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = NewsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}