package com.example.domain.models

data class ErrorResponse(
    val error: Exception?,
    val networkError: Boolean = false
)