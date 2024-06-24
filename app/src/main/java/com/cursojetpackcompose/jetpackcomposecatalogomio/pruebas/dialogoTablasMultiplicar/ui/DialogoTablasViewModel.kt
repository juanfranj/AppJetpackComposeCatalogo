package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.dialogoTablasMultiplicar.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DialogoTablasViewModel @Inject constructor() : ViewModel() {

    private val _showDialogo = MutableLiveData<Boolean>(false)
    val showDialogo: LiveData<Boolean> = _showDialogo

    private val _correctas = MutableLiveData<Int>(0)
    val correctas: LiveData<Int> = _correctas

    private val _errores = MutableLiveData<Int>(0)
    val errores: LiveData<Int> = _errores

    fun changeDialogo(navigationController: NavController) {

//        navigationController.navigate(Routes.PantallaPrueba.route)
        _showDialogo.value = !_showDialogo.value!!

    }

    fun incrementarAciertos(){
        _correctas.value = _correctas.value!! + 1
    }
    fun decrementarAciertos(){
        _correctas.value = _correctas.value!! - 1
    }
    fun incrementarErrores(){
        _errores.value = _errores.value!! + 1
    }
    fun decrementarErrores(){
        _errores.value = _errores.value!! - 1
    }
}

