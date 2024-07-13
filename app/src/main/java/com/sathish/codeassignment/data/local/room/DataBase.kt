package com.sathish.codeassignment.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sathish.codeassignment.data.local.room.dao.MedicineDao
import com.sathish.codeassignment.data.local.room.entity.MedicineEntity

/**
 * Created by sathish on 11,July,2024
 */
@Database(entities = [MedicineEntity::class], version = 1)
abstract class DataBase:RoomDatabase()
{
abstract fun medicineDao():MedicineDao
}