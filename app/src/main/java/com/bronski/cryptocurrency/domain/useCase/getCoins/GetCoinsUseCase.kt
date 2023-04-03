package com.bronski.cryptocurrency.domain.useCase.getCoins

import com.bronski.cryptocurrency.common.Resource
import com.bronski.cryptocurrency.data.remote.dto.toCoin
import com.bronski.cryptocurrency.domain.model.Coin
import com.bronski.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        runCatching {
            emit(Resource.Loading())
            repository.getCoins().map { it.toCoin() }
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