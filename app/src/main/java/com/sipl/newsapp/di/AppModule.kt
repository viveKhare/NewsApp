package com.sipl.newsapp.di

import com.sipl.newsapp.common.Constant
import com.sipl.newsapp.data.remote.NewsAPI
import com.sipl.newsapp.data.repository.NewsRepositoryImpl
import com.sipl.newsapp.domain.respository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi(): NewsAPI {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api: NewsAPI): NewsRepository {
        return NewsRepositoryImpl(api)
    }
}