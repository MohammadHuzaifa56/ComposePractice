package com.example.composepractice.data.remote.dto

import com.squareup.moshi.Json

data class IntrdayInfoDto(
    val timestamp: String,
    val close: Double,
)