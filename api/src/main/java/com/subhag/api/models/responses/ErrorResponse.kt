package com.subhag.api.models.responses

data class ErrorResponse(
    val code: String,
    val message: String,
    val status: String
)