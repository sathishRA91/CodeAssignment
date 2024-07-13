package com.sathish.codeassignment.data.remote

import com.sathish.codeassignment.data.model.MedicationMainDataDto

/**
 * Created by sathish on 11,July,2024
 */
interface RemoteDataSource {

    suspend fun getMedicine(): MedicationMainDataDto
}