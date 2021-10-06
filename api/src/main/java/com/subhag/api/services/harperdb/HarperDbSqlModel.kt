package com.subhag.api.services.harperdb

data class HarperDbSqlModel(
    val sql: String,
    val operation: String = "sql"
)
