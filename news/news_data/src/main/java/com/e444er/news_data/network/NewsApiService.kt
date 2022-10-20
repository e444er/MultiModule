package com.e444er.news_data.network

import com.e444er.common_utils.Constants
import com.e444er.news_data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiService {

    // https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=950deeb7252a4250ac13c8ff27df15f6

    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country:String,
        @Query("category") category: String= Constants.CATEGORY,
        @Query("apiKey") apiKey:String = Constants.API_KEY
    ): NewsResponse

}