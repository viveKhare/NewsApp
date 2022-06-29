package com.sipl.newsapp.domain.use_cases

import com.sipl.newsapp.common.Resource
import com.sipl.newsapp.data.remote.dto.Article
import com.sipl.newsapp.data.remote.dto.NewsData
import com.sipl.newsapp.domain.respository.NewsRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: NewsRepository) {
    operator fun invoke() = flow {
        try {
            emit(Resource.Loading<List<Article>>())
            val coin = repository.getNews()
            emit(Resource.Success<List<Article>>(coin))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Article>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<Article>>("Couldn't reach server. Check your internet connection."))
        }

    }

}