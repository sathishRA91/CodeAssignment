package com.sathish.codeassignment.data.model

import com.google.gson.annotations.SerializedName
import com.sathish.codeassignment.domain.model.ProblemData

data class ProblemDataDto(
    @SerializedName("Diabetes")
    val diabetes: List<DiabetesDataDto>?=null
)

fun ProblemDataDto.toDomain() = ProblemData(diabetes = diabetes?.map { it.toDomain() }?: emptyList())