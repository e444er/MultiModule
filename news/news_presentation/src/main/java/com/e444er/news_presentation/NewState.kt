package com.e444er.news_presentation

import com.e444er.news_domain.model.Article

data class NewsState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:List<Article>?=null
)