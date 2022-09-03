package com.example.composepractice.presentation.company_info
import com.example.composepractice.domain.model.CompanyInfo
import com.example.composepractice.domain.model.IntradayInfo
import com.example.composepractice.utils.Resource

data class CompanyInfoState(
    val stockInfos: List<IntradayInfo> = emptyList(),
    val company: CompanyInfo?= null,
    val isLoading: Boolean = false,
    val error: String? = null
)
