package com.e444er.news_domain.repository

import com.e444er.news_domain.model.Article

interface NewsRepository {

    suspend fun getNewsArticle():List<Article>

}