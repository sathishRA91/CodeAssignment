package com.sathish.codeassignment.data.repositoryimpl

import com.sathish.codeassignment.data.local.LocalDataSource
import com.sathish.codeassignment.data.local.room.entity.MedicineEntity
import com.sathish.codeassignment.data.model.MedicationMainDataDto
import com.sathish.codeassignment.data.remote.RemoteDataSource
import com.sathish.codeassignment.domain.repository.MedicineRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MedicineRepositoryImpl @Inject constructor (private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource) : MedicineRepository {

    override suspend fun getMedicine(): MedicationMainDataDto = remoteDataSource.getMedicine()

    override suspend fun insertMedicine(medicineEntity: MedicineEntity) {

        localDataSource.insertMedicine(medicineEntity)
    }

    override suspend fun getAllMedicine(): Flow<List<MedicineEntity>> = localDataSource.getAllMedicine()

    override suspend fun deleteAllMedicine() {
       localDataSource.deleteAllMedicine()
    }
}