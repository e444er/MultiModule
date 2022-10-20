package com.e444er.news_data.mapper

import com.e444er.news_data.model.ArticleDTO
import com.e444er.news_domain.model.Article

fun ArticleDTO.toDomainArticle(): Article {
    return Article(
        author = this.author ?: "",
        content = this.content ?: "",
        description = this.description ?: "",
        title = this.title ?: "",
        urlToImage = this.urlToImage ?: ""
    )
}