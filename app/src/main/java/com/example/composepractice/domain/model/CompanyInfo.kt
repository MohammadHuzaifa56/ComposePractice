package com.example.composepractice.domain.model

import com.squareup.moshi.Json

data class CompanyInfo(
    val symbol: String?,
    val description: String?,
    val name: String?,
    val industry: String?,
    val country: String?
)