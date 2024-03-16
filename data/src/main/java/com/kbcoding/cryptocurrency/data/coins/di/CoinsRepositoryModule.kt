package com.kbcoding.cryptocurrency.data.coins.di

import com.kbcoding.cryptocurrency.data.coins.domain.repository.CoinsDataRepository
import com.kbcoding.cryptocurrency.data.coins.repository.CoinsDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoinsRepositoryModule {

    @Binds
    @Singleton
    fun bindCoinsDataRepository(repository: CoinsDataRepositoryImpl): CoinsDataRepository
}