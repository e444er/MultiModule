package com.e444er.search_data.repository

import com.e444er.search_data.mappers.toDomainArticle
import com.e444er.search_data.network.SearchApi
import com.e444er.search_domain.model.Article
import com.e444er.search_domain.repository.SearchRepository

class SearchRepositoryImpl(private val searchApi: SearchApi) : SearchRepository {

    override suspend fun getSearchArticles(map: MutableMap<String, String>): List<Article> {
        return searchApi.getSearchArticles(map).articles.map { it.toDomainArticle() }
    }
}