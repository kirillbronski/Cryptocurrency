package com.kbcoding.cryptocurrency.fetures.coinlist.domain.useCase

import com.kbcoding.cryptocurrency.core.common.Resource
import com.kbcoding.cryptocurrency.domain.repository.CoinRepository
import com.kbcoding.cryptocurrency.mappers.toCoin
import com.kbcoding.cryptocurrency.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        runCatching {
            emit(Resource.Loading())
            repository.getCoins()
        }.fold(
            onSuccess = {
                emit(Resource.Success(it))
            },
            onFailure = {
                emit(Resource.Error(it.localizedMessage ?: "An unexpected error occurred"))
                it.printStackTrace()
            }
        )
    }
}