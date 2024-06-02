package com.cursojetpackcompose.jetpackcomposecatalogomio.StateFlow.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StateFlowViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        // Simular una operación de carga
        viewModelScope.launch {
            delay(2000) // Simular un retraso
            // Simular éxito o error basado en una condición
            val success = true // Puedes cambiar esto para probar ambos casos
            if (success) {
                _uiState.value = UiState.Success("Carga exitosa")
            } else {
                _uiState.value = UiState.Error("Ha ocurrido un error")
            }
        }
    }
}
