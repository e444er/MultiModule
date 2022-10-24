package com.e444er.search_presentation

import com.e444er.search_domain.model.Article

data class SearchState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:List<Article>?=null
)