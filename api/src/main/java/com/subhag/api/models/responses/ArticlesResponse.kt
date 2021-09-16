package com.subhag.api.models.responses

import com.subhag.api.models.entities.Article

data class ArticlesResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)