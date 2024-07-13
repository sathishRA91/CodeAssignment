package com.sathish.codeassignment.data.model

import com.sathish.codeassignment.domain.model.AssociatedDrugData

data class AssociatedDrugDataDto(
    val dose: String,
    val name: String,
    val strength: String
)

fun AssociatedDrugDataDto.toDomain() = AssociatedDrugData(dose = dose,
    name = name, strength = strength)