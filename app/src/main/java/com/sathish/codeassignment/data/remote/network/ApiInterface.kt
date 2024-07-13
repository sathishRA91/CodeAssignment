package com.sathish.codeassignment.data.remote.network


import com.sathish.codeassignment.data.model.MedicationMainDataDto
import retrofit2.http.GET

/**
 * Created by sathish on 11,July,2024
 */
interface ApiInterface {

    @GET(ApiConfig.GET_MEDICINE)
    suspend fun getMedicine():MedicationMainDataDto

}