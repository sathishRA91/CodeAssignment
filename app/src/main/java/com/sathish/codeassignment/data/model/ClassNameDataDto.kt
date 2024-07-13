package com.sathish.codeassignment.data.model

import com.google.gson.annotations.SerializedName
import com.sathish.codeassignment.domain.model.ClassNameData

data class ClassNameDataDto(
    @SerializedName("associatedDrug")
    val associatedDrug: List<AssociatedDrugDataDto>,
    @SerializedName("associatedDrug2")
    val associatedDrugTwo: List<AssociatedDrugDataDto>
)

fun ClassNameDataDto.toDomain() = ClassNameData(associatedDrug = associatedDrug.map { it.toDomain() },
    associatedDrugTwo = associatedDrugTwo.map { it.toDomain() })