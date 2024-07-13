package com.sathish.codeassignment.di

import com.sathish.codeassignment.domain.repository.MedicineRepository
import com.sathish.codeassignment.domain.usecase.DeleteAllMedicineUseCase
import com.sathish.codeassignment.domain.usecase.GetAllMedicineUseCase
import com.sathish.codeassignment.domain.usecase.GetMedicineUseCase
import com.sathish.codeassignment.domain.usecase.InsertMedicineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by sathish on 11,July,2024
 */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideDeleteMedicineUseCase(repository: MedicineRepository) = DeleteAllMedicineUseCase(repository)

    @Provides
    @Singleton
    fun provideInsertMedicineUseCase(repository: MedicineRepository) = InsertMedicineUseCase(repository)

    @Provides
    @Singleton
    fun provideGetAllMedicineUseCase(repository: MedicineRepository) = GetAllMedicineUseCase(repository)

    @Provides
    @Singleton
    fun provideGetMedicineUseCase(repository: MedicineRepository) = GetMedicineUseCase(repository)
}