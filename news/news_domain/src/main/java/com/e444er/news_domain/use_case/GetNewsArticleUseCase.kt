package com.e444er.news_domain.use_case

import com.e444er.common_utils.Resource
import com.e444er.news_domain.model.Article
import com.e444er.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsArticleUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = newsRepository.getNewsArticle()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}