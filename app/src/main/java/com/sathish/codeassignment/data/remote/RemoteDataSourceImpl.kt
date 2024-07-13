package com.sathish.codeassignment.data.remote

import com.sathish.codeassignment.data.model.MedicationMainDataDto
import com.sathish.codeassignment.data.remote.network.ApiInterface
import javax.inject.Inject

/**
 * Created by sathish on 11,July,2024
 */
class RemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiInterface) : RemoteDataSource {
    override suspend fun getMedicine():MedicationMainDataDto {
        return apiInterface.getMedicine()
    }
}