package com.e444er.search_domain.repository

import com.e444er.search_domain.model.Article

interface SearchRepository {

    suspend fun getSearchArticles(map:MutableMap<String,String>):List<Article>

}