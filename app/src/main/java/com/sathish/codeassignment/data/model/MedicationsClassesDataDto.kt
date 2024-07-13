package com.sathish.codeassignment.data.model

import com.sathish.codeassignment.domain.model.MedicationsClassesData

data class MedicationsClassesDataDto(
    val className: List<ClassNameDataDto>,
    val className2: List<ClassNameDataDto>
)

fun MedicationsClassesDataDto.toDomain() = MedicationsClassesData(className = className.map { it.toDomain() },
    className2 = className2.map { it.toDomain() })