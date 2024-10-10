package com.android.hilt.di

import com.android.hilt.utils.DummyData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DummyModule {

    @Provides
    @Singleton
    fun provideDummyData(
    ): DummyData {
        return DummyData()
    }
}