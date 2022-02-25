package com.plcoding.cryptocurrencyapp.presentation.coin_detail.viewstate

import com.plcoding.cryptocurrencyapp.domain.model.Coin
import com.plcoding.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
