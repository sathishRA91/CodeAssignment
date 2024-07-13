package com.sathish.codeassignment.data.local

import com.sathish.codeassignment.data.local.room.DataBase
import com.sathish.codeassignment.data.local.room.dao.MedicineDao
import com.sathish.codeassignment.data.local.room.entity.MedicineEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dataBase: DataBase) : LocalDataSource {
    override suspend fun insertMedicine(medicineEntity: MedicineEntity) {
        dataBase.medicineDao().insertMedicine(medicineEntity)
    }

    override suspend fun getAllMedicine(): Flow<List<MedicineEntity>> {
      return dataBase.medicineDao().getAllMedicine()
    }

    override suspend fun deleteAllMedicine() {
        dataBase.medicineDao().deleteAllMedicine()
    }
}