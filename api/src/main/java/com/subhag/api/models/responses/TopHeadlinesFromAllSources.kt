package com.subhag.api.models.responses

import com.subhag.api.models.entities.Article
import com.subhag.api.models.entities.Source

data class TopHeadlinesFromAllSources(
    val sources: List<Source>,
    val status: String,
    val articles: List<Article>
)
