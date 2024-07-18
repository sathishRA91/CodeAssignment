package com.sathish.codeassignment.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sathish.codeassignment.domain.model.AssociatedDrugData
import com.sathish.codeassignment.domain.usecase.DeleteAllMedicineUseCase
import com.sathish.codeassignment.domain.usecase.GetAllMedicineUseCase
import com.sathish.codeassignment.domain.usecase.GetMedicineUseCase
import com.sathish.codeassignment.domain.usecase.InsertMedicineUseCase
import com.sathish.codeassignment.presentation.ui.UiState
import com.sathish.codeassignment.util.ResultResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by sathish on 12,July,2024
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    val getMedicineUseCase: GetMedicineUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<AssociatedDrugData>>>(UiState.Idle())
    val uiState = _uiState.asStateFlow()

init {
    getMedicine()
}
    fun getMedicine()
    {
        viewModelScope.launch {

            getMedicineUseCase.invoke().collectLatest {
                when(it)
                {
                    is ResultResource.Success ->{
                        _uiState.value = UiState.Success(it.data)
                    }

                    is ResultResource.ErrorMessage -> {

                    }
                }

            }

        }
    }
}