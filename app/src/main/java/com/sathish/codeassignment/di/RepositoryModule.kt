package com.sathish.codeassignment.di

import com.sathish.codeassignment.data.local.LocalDataSource
import com.sathish.codeassignment.data.local.LocalDataSourceImpl
import com.sathish.codeassignment.data.remote.RemoteDataSource
import com.sathish.codeassignment.data.remote.RemoteDataSourceImpl
import com.sathish.codeassignment.data.repositoryimpl.MedicineRepositoryImpl
import com.sathish.codeassignment.domain.repository.MedicineRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by sathish on 11,July,2024
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl):RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindMedicineRepository(medicineRepositoryImpl: MedicineRepositoryImpl):MedicineRepository
}