package com.subhag.api

import org.junit.Assert.assertEquals
import org.junit.Test

class NewsApiTest {

    @Test
    fun `Test GET top headlines from News API`() {
        val api = NewsApiClient().newsApi
        val articles = api
            .getTopHeadlinesFromAllSources()
            .blockingGet()

        assertEquals(articles.status, STATUS_OK)
    }

    companion object {

        private const val STATUS_OK = "ok"

    }

}