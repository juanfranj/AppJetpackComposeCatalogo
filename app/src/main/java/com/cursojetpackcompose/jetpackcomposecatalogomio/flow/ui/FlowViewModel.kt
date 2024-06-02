package com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursojetpackcompose.jetpackcomposecatalogomio.flow.data.SuscribeteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Anotación para que Hilt pueda manejar la inyección de dependencias en este ViewModel
@HiltViewModel
class FlowViewModel @Inject constructor(
    // Inyección del repositorio usando Hilt
    private val suscribeteRepository: SuscribeteRepository
) : ViewModel() {

    // Flow mutable para el estado del contador
    private val _counterState = MutableStateFlow(0)
    val counterState: StateFlow<Int> = _counterState

    private var hasStarted = false

    // Función que inicia la colección del Flow
    fun startCounterFlow() {
        if(!hasStarted){
            hasStarted = true
            viewModelScope.launch {

                // Suscribirse al Flow expuesto por el repositorio
                suscribeteRepository.counter.collect { bombitas ->
                    // Imprimir el valor emitido por el Flow en el logcat con la etiqueta "juanfran"
                    _counterState.value = bombitas
                }
            }
        }
        // Es necesario lanzar el Flow en el viewModelScope para que respete el ciclo de vida del ViewModel

    }
    fun resetCounter() {
        _counterState.value = 0
    }

    fun startCounter() {
        suscribeteRepository.startCounter()
        startCounterFlow()
    }
    fun stopCounter() {
        suscribeteRepository.stopCounter()
        hasStarted = false
    }

}


