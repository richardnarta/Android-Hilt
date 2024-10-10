package com.android.hilt.di

import com.android.hilt.repository.FirstRepository
import com.android.hilt.repository.SecondRepository
import com.android.hilt.utils.DummyData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFirstRepository(
        dummy: DummyData
    ): FirstRepository {
        return FirstRepository(dummy)
    }

    @Provides
    @Singleton
    fun provideSecondRepository(
        dummy: DummyData
    ): SecondRepository {
        return SecondRepository(dummy)
    }
}