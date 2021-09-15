package com.subhag.api.services

import com.subhag.api.models.responses.TopHeadlinesFromAllSources
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {

    @GET("/v2/top-headlines")
    fun getTopHeadlinesFromAllSources(
        @Query("category") category: String? = null,
        @Query("country") country: String? = "in",
        @Query("sources") sources: String? = null,
        @Query("q") query: String? = null,
        @Query("pagesize") pageSize: Int? = null,
        @Query("page") page: Int? = null
    ): Single<TopHeadlinesFromAllSources>

    companion object {

        const val BASE_URL = "https://newsapi.org"

    }

}