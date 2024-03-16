package com.kbcoding.cryptocurrency.features.coindetail.domain.useCase

import com.kbcoding.cryptocurrency.core.common.Resource
import com.kbcoding.cryptocurrency.domain.repository.CoinRepository
import com.kbcoding.cryptocurrency.mappers.toCoinDetail
import com.kbcoding.cryptocurrency.model.CoinDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        runCatching {
            emit(Resource.Loading())
            repository.getCoinById(coinId)
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