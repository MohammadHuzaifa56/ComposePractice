package com.example.composepractice.presentation.company_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composepractice.domain.repository.StockRepository
import com.example.composepractice.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val stockRepository: StockRepository
): ViewModel() {
    var state by mutableStateOf(CompanyInfoState())

    init {
        viewModelScope.launch{
            val symbol = savedStateHandle.get<String>("symbol")?: return@launch
            state = state.copy(isLoading = true)
            val companyInfoResult = async { stockRepository.getCompanyInfo(symbol) }
            val intradayInfoResult = async { stockRepository.getIntraDayInfo(symbol) }

            when (val result = companyInfoResult.await()) {
                is Resource.Success -> {
                    state = state.copy(
                        company = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        company = null,
                        error = result.message
                    )
                }
                else -> Unit
            }

            when (val result = intradayInfoResult.await()) {
                is Resource.Success -> {
                    state = state.copy(
                        stockInfos = result.data ?: emptyList(),
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        stockInfos = emptyList(),
                        error = result.message
                    )
                }
                else -> Unit
            }
        }
    }
}