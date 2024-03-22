package com.games.colormix.manager

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO


@Module
@InstallIn(SingletonComponent::class)
object CoroutineDispatcherModule {
    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher {
        // Return the CoroutineDispatcher instance you want to use
        return IO // For example, using the IO dispatcher
    }
}