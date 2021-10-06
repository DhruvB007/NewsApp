package com.subhag.api.services.newsapp

import com.subhag.api.models.responses.ArticlesResponse
import com.subhag.api.models.responses.TopHeadlinesFromAllSources
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlinesFromAllSources(
        @Query("category") category: String? = null,
        @Query("country") country: String? = "in",
        @Query("sources") sources: String? = null,
        @Query("q") query: String? = null,
        @Query("pagesize") pageSize: Int? = null,
        @Query("page") page: Int? = null
    ): Response<TopHeadlinesFromAllSources>

    @GET("/v2/everything")
    suspend fun getAllArticles(
        @Query("q") query: String
    ): Response<ArticlesResponse>

    companion object {

        const val BASE_URL = "https://newsapi.org"

    }

}