package com.sathish.codeassignment.domain.usecase

import com.sathish.codeassignment.domain.repository.MedicineRepository
import javax.inject.Inject

/**
 * Created by sathish on 11,July,2024
 */
class DeleteAllMedicineUseCase @Inject constructor(private val repository: MedicineRepository)
{
    suspend operator fun invoke()
    {
        repository.deleteAllMedicine()
    }
}