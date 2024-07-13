package com.sathish.codeassignment.data.local

import com.sathish.codeassignment.data.local.room.dao.MedicineDao
import com.sathish.codeassignment.data.local.room.entity.MedicineEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by sathish on 11,July,2024
 */
interface LocalDataSource {

    suspend fun insertMedicine(medicineEntity: MedicineEntity)

    suspend fun getAllMedicine():Flow<List<MedicineEntity>>

    suspend fun deleteAllMedicine()
}