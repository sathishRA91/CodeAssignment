package com.sathish.codeassignment.domain.usecase

import com.sathish.codeassignment.domain.repository.MedicineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by sathish on 11,July,2024
 */
class GetAllMedicineUseCase @Inject constructor(private val repository: MedicineRepository)
{

}