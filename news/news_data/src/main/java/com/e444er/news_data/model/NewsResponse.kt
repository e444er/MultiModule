package com.e444er.news_data.model

data class NewsResponse(
    val articles: List<ArticleDTO>,
    val status: String,
    val totalResults: Int
)
