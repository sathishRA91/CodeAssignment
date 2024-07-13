package com.sathish.codeassignment.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sathish.codeassignment.data.local.room.entity.MedicineEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by sathish on 11,July,2024
 */
@Dao
interface MedicineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicine(medicineEntity: MedicineEntity)

    @Query("SELECT * FROM medicineEntity")
    fun getAllMedicine():Flow<List<MedicineEntity>>

    @Query("DELETE FROM medicineEntity")
    suspend fun deleteAllMedicine()

}