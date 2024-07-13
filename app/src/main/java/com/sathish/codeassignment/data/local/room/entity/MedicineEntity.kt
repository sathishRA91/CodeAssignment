package com.sathish.codeassignment.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sathish.codeassignment.domain.model.AssociatedDrugData

/**
 * Created by sathish on 11,July,2024
 */

@Entity(tableName = "medicineEntity")
data class MedicineEntity(@PrimaryKey(autoGenerate = true) val id:Int, val name:String, val dose:String, val strength:String) {}

fun MedicineEntity.toDomain() = AssociatedDrugData(name = name, dose = dose, strength = strength)