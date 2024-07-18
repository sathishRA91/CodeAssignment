package com.sathish.codeassignment.presentation.home

import app.cash.turbine.test
import com.sathish.codeassignment.domain.model.AssociatedDrugData
import com.sathish.codeassignment.domain.usecase.GetMedicineUseCase
import com.sathish.codeassignment.presentation.ui.UiState
import com.sathish.codeassignment.util.ResultResource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

/**
 * Created by sathish on 12,July,2024
 */
@ExperimentalCoroutinesApi
class HomeViewModelTest {

    private val useCaseMock = mockk<GetMedicineUseCase>(relaxed = true)
    private lateinit var homeViewModel: HomeViewModel


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        homeViewModel = HomeViewModel(useCaseMock)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }


    @Test
    fun `return medicine test data true`() = runTest {
        val mockData:ResultResource<List<AssociatedDrugData>> = ResultResource.Success(listOf(AssociatedDrugData("test","test","test")))
        coEvery { useCaseMock.invoke() } returns flowOf(mockData)
        homeViewModel.uiState.test{
            homeViewModel.getMedicine()
            assertEquals(awaitItem().data, UiState.Idle<List<AssociatedDrugData>>().data)
            assertEquals(awaitItem().data,mockData.data)
            cancelAndIgnoreRemainingEvents()
        }
    }

}