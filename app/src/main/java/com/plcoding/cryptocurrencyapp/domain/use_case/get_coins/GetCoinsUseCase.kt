package com.plcoding.cryptocurrencyapp.domain.use_case.get_coins

import com.plcoding.cryptocurrencyapp.common.Resource
import com.plcoding.cryptocurrencyapp.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyapp.domain.model.Coin
import com.plcoding.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't read server. Check your internet connect"))
        }
    }
}