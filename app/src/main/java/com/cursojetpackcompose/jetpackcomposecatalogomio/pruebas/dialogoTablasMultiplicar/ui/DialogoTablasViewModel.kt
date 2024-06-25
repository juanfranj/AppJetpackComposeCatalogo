package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.dialogoTablasMultiplicar.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.cursojetpackcompose.jetpackcomposecatalogomio.R
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.roundToInt

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

    //Incluir en viewmodel original
    private fun calcularNota(correctos: Int, errores: Int): Int {
        if (correctos < 0 || errores < 0) {
            return  0
        }
        val suma = correctos + errores
        if (suma == 0) {
           return 0
        }
        val nota = (correctos.toDouble() / suma) * 10
        Log.i("juanfran", "calcularNota: $nota")
        return nota.roundToInt()
    }

    @Composable
    fun obtenerTextoNota(correctos: Int, errores: Int): String {
        val nota =  calcularNota(correctos, errores)
        return when {
            nota < 5 -> stringResource(R.string.Nota_suspenso)
            nota in 5..6 -> stringResource(R.string.Nota_aprobado)
            nota in 7..8 -> stringResource(R.string.Nota_notable)
            nota in 9..10 -> stringResource(R.string.Nota_sobresaliente)
            else -> "Nota fuera de rango: $nota"
        }
    }

    fun obtenerNumeroEstrellas(correctos: Int, errores: Int): Int {
        val nota =  calcularNota(correctos, errores)
        return when (nota) {
            in 0..4 -> 0
            5 -> 1
            6 -> 2
            in 7..8 -> 3
            in 9..10 -> 4
            else -> 0
        }
    }

}

