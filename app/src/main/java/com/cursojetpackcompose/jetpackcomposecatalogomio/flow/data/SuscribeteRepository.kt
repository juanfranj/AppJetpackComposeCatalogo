package com.cursojetpackcompose.jetpackcomposecatalogomio.flow.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SuscribeteRepository @Inject constructor() {

    private var comenzar = true
    var counter: Flow<Int> = flow {
        var bombitas = 0
        while (comenzar) {
            bombitas += 1
            emit(bombitas)
            delay(1000)
        }
    }
    // Función para detener el contador si es necesario
    fun stopCounter() {
        comenzar = false
    }

    // Función para reiniciar el contador
    fun startCounter() {
        comenzar = true
    }
}