package com.sathish.codeassignment.domain.usecase

import com.sathish.codeassignment.domain.repository.MedicineRepository
import javax.inject.Inject

/**
 * Created by sathish on 11,July,2024
 */
class InsertMedicineUseCase @Inject constructor(private val repository: MedicineRepository)
{

    operator fun invoke()
    {

    }
}