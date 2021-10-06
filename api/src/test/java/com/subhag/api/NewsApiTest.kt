package com.subhag.api

import com.subhag.api.services.newsapp.NewsApiClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class NewsApiTest {

    private val newsApi = NewsApiClient().newsApi

    @Test
    fun `Test GET top headlines from News API`() {
        runBlocking {
            val articlesResponse = newsApi.getTopHeadlinesFromAllSources()
            assertEquals(articlesResponse.isSuccessful, true)
            assertNotEquals(0, articlesResponse.body()?.articles?.size)
        }
    }

    @Test
    fun `Test GET search results given a query`() {
        runBlocking {
            val articlesResponse = newsApi.getAllArticles("Elon musk")
            assertEquals(articlesResponse.isSuccessful, true)
            assertNotEquals(0, articlesResponse.body()?.articles?.size)
        }
    }

    companion object {

        private const val STATUS_OK = "ok"

    }

}