package com.sathish.codeassignment.data.model

import com.sathish.codeassignment.domain.model.DiabetesData

data class DiabetesDataDto(
    val labs: List<LabDataDto>?=null,
    val medications: List<MedicationDataDto>?=null
)

fun DiabetesDataDto.toDomain() = DiabetesData(medications = medications?.map { it.toDomain() }?: emptyList())