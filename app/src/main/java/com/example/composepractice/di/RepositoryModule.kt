package com.example.composepractice.di

import com.example.composepractice.data.csv.CSVParser
import com.example.composepractice.data.csv.CompanyListingParser
import com.example.composepractice.data.csv.IntradayInfoParser
import com.example.composepractice.data.respository.StockRepositoryImpl
import com.example.composepractice.domain.model.CompanyListing
import com.example.composepractice.domain.model.IntradayInfo
import com.example.composepractice.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCompanyListingParser(companyListingParser: CompanyListingParser): CSVParser<CompanyListing>

    @Binds
    abstract fun bindIntraDayInfoParser(intradayInfoParser: IntradayInfoParser): CSVParser<IntradayInfo>

    @Binds
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}