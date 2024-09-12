package com.games.colormix.manager

import com.games.colormix.FirebaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object FirebaseRepositoryModule {
    @Provides
    fun provideFirebaseRepositoryModule(): FirebaseRepository {

        return FirebaseRepository()
    }
}