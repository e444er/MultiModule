package com.e444er.search_domain.di

import com.e444er.search_domain.repository.SearchRepository
import com.e444er.search_domain.use_case.GetSearchArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object SearchDomainModule {

    @Provides
    fun provideSearchUseCase(searchRepository: SearchRepository): GetSearchArticleUseCase {
        return GetSearchArticleUseCase(searchRepository)
    }

}