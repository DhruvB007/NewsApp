package com.subhag.api

import org.junit.Assert.*
import org.junit.Test

class NewsApiTest {

    private val newsApi = NewsApiClient().newsApi

    @Test
    fun `Test GET top headlines from News API`() {
        val articlesResponse = newsApi
            .getTopHeadlinesFromAllSources()
            .blockingGet()

        assertEquals(articlesResponse.status, STATUS_OK)
        assertNotEquals(0, articlesResponse.articles.size)
    }

    @Test
    fun `Test GET search results given a query`() {
        val articlesResponse = newsApi
            .getAllArticles("Elon Musk")
            .blockingGet()

        assertEquals(articlesResponse.status, STATUS_OK)
        assertNotEquals(0, articlesResponse.articles.size)
    }

    companion object {

        private const val STATUS_OK = "ok"

    }

}