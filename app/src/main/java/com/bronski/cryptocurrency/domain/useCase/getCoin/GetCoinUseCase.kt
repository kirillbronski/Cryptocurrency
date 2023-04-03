package com.bronski.cryptocurrency.domain.useCase.getCoin

import com.bronski.cryptocurrency.common.Resource
import com.bronski.cryptocurrency.data.remote.dto.toCoinDetail
import com.bronski.cryptocurrency.domain.model.CoinDetail
import com.bronski.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        runCatching {
            emit(Resource.Loading())
            repository.getCoinById(coinId).toCoinDetail()
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