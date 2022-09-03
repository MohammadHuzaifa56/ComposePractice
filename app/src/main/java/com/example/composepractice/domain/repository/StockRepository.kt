package com.example.composepractice.domain.repository

import com.example.composepractice.domain.model.CompanyInfo
import com.example.composepractice.domain.model.CompanyListing
import com.example.composepractice.domain.model.IntradayInfo
import com.example.composepractice.utils.Resource
import kotlinx.coroutines.flow.Flow


interface StockRepository {

    suspend fun getIntraDayInfo(symbol: String): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo>

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

}