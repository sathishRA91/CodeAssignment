package com.sathish.codeassignment.domain.repository

import com.sathish.codeassignment.data.local.room.entity.MedicineEntity
import com.sathish.codeassignment.data.model.MedicationMainDataDto
import kotlinx.coroutines.flow.Flow

/**
 * Created by sathish on 11,July,2024
 */
interface MedicineRepository
{

    suspend fun getMedicine():MedicationMainDataDto

    suspend fun insertMedicine(medicineEntity: MedicineEntity)

    suspend fun getAllMedicine(): Flow<List<MedicineEntity>>

    suspend fun deleteAllMedicine()

}