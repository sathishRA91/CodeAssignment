package com.sathish.codeassignment.domain.model

import com.google.gson.annotations.SerializedName

data class ClassNameData(
    @SerializedName("associatedDrug")
    val associatedDrug: List<AssociatedDrugData>,
    @SerializedName("associatedDrug#2")
    val associatedDrugTwo: List<AssociatedDrugData>
)