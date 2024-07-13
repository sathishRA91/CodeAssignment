package com.sathish.codeassignment.data.model

import com.sathish.codeassignment.domain.model.MedicationData

data class MedicationDataDto(
    val medicationsClasses: List<MedicationsClassesDataDto>
)

fun MedicationDataDto.toDomain() = MedicationData(medicationsClasses = medicationsClasses.map { it.toDomain() })