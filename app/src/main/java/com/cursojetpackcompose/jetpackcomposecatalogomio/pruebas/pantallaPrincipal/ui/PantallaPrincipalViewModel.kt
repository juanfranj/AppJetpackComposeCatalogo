package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.pantallaPrincipal.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PantallaPrincipalViewModel @Inject constructor(
    // Aquí puedes inyectar tus repositorios u otras dependencias
) : ViewModel() {

    // Aquí puedes agregar lógica de estado, funciones de negocio, etc.
    // Lista observable de tarjetas usando pares: nombre + nombreImagen
    private val _tarjetas = mutableStateListOf(
        Pair("Estudiar", "estudiarprincipal"),
        Pair("Jugar", "jugarprincipal"),
//        Pair("Clasificacion", "estudiarprincipal"),
//        Pair("Tienda", "jugarprincipal"),
    )
    val tarjetas: List<Pair<String, String>> get() = _tarjetas

    fun actualizarTarjetas(nuevaLista: List<Pair<String, String>>) {
        _tarjetas.clear()
        _tarjetas.addAll(nuevaLista)
    }

    fun agregarTarjeta(nombre: String, imagen: String) {
        _tarjetas.add(Pair(nombre, imagen))
    }

    fun eliminarTarjeta(nombre: String) {
        _tarjetas.removeAll { it.first == nombre }
    }
}