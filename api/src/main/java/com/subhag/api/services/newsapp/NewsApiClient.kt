package com.subhag.api.services.newsapp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class NewsApiClient {

    private val authInterceptor = Interceptor { chain ->
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        requestBuilder.header(HEADER_X_API_KEY, API_KEY)
        chain.proceed(requestBuilder.build())
    }

    private val okHttpBuilder = OkHttpClient.Builder()
        .readTimeout(5, TimeUnit.SECONDS)
        .callTimeout(2, TimeUnit.SECONDS)

    private val okHttpClient = okHttpBuilder
        .addInterceptor(authInterceptor)
        .build()

    private val retrofit = Retrofit
        .Builder()
        .client(okHttpClient)
        .baseUrl(NewsApi.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()


    val newsApi: NewsApi = retrofit.create(NewsApi::class.java)

    companion object {

        private const val HEADER_X_API_KEY = "x-api-key"
        private const val API_KEY = "d81af4eb8f764c38a867df76556cd66f"

    }

}