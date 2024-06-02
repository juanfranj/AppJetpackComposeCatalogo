package com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursojetpackcompose.jetpackcomposecatalogomio.flow.data.SuscribeteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
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
                suscribeteRepository.counter
                    .map {it.toString()}//para mapear los datos que llegan
                    .collect { bombitas: String ->
                    _counterState.value = bombitas.toInt()
                }
            }
        }
        // Es necesario lanzar el Flow en el viewModelScope para que respete el ciclo de vida del ViewModel

    }
    fun resetCounter() {
//        stopCounter()
        _counterState.value = 0
//        startCounter()
    }

    fun startCounter() {
        suscribeteRepository.startCounter()
        startCounterFlow()
    }
    fun stopCounter() {
        suscribeteRepository.stopCounter()
        hasStarted = false
    }

    fun example(){
        viewModelScope.launch {
            // Suscribirse al Flow expuesto por el repositorio
            suscribeteRepository.counter
                .map {it.toString()}//para mapear los datos que llegan
                .onEach {save(it)}//Cada valor lo mando a la funcion save para que haga algo
                .catch { error ->
                    Log.i("juanfran","Error: ${error.cause}")
                }
                .collect { bombitas: String ->
                    // Imprimir el valor emitido por el Flow en el logcat con la etiqueta "juanfran"
                    Log.i("juanfran",bombitas)
                }
        }
    }

    private fun save(info: String) {

    }

}


