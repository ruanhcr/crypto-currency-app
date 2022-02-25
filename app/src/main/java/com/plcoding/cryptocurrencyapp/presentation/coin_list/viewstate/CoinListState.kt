package com.plcoding.cryptocurrencyapp.presentation.coin_list.viewstate

import com.plcoding.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
