package com.sathish.codeassignment.domain.usecase

import com.sathish.codeassignment.data.model.toDomain
import com.sathish.codeassignment.domain.model.AssociatedDrugData
import com.sathish.codeassignment.domain.model.MedicationMainData
import com.sathish.codeassignment.domain.repository.MedicineRepository
import com.sathish.codeassignment.util.ResultResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by sathish on 11,July,2024
 */
class GetMedicineUseCase @Inject constructor(private val repository: MedicineRepository)
{

    operator fun invoke():Flow<ResultResource<List<AssociatedDrugData>>> = flow {

        val result =repository.getMedicine().toDomain().problems.asSequence().flatMap { it.diabetes}
                        .flatMap{ it.medications}
                        .flatMap { it.medicationsClasses}
                        .flatMap { it.className+it.className2 }
                        .flatMap { it.associatedDrug+it.associatedDrugTwo }.toList()
                    emit(ResultResource.Success(result))
                }

    }
