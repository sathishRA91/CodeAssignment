package com.sathish.codeassignment.data.model

import com.google.gson.annotations.SerializedName
import com.sathish.codeassignment.domain.model.MedicationMainData

data class MedicationMainDataDto(
    @SerializedName("problems")
    val problems: List<ProblemDataDto>?=null
)

fun MedicationMainDataDto.toDomain() = MedicationMainData(
    problems = problems?.map { it.toDomain() }?: emptyList()
)