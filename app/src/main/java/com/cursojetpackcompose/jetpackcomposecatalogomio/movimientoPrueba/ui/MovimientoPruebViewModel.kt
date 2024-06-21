package com.cursojetpackcompose.jetpackcomposecatalogomio.movimientoPrueba.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

@HiltViewModel
class MovimientoPruebaViewModel @Inject constructor() : ViewModel() {

    private val _text1 = MutableLiveData<String>("Texto 1")
    val text1: LiveData<String> = _text1

    private val _text2 = MutableLiveData<String>("Texto 1")
    val text2: LiveData<String> = _text2

    private val _text3 = MutableLiveData<String>("Texto 1")
    val text3: LiveData<String> = _text3

    private val _boxPosition = MutableLiveData<Pair<Float, Float>>(Pair(0f, 0f))
    val boxPosition: LiveData<Pair<Float, Float>> = _boxPosition

    private val _buttonPosition = MutableLiveData<Pair<Float, Float>>(Pair(0f, 0f))
    val buttonPosition: LiveData<Pair<Float, Float>> = _buttonPosition

    private val _buttonPositionInParent = MutableLiveData<Pair<Float, Float>>(Pair(0f, 0f))
    val buttonPositionInParent: LiveData<Pair<Float, Float>> = _buttonPositionInParent

    private val _distance = MutableLiveData<Float>(0f)
    val distance: LiveData<Float> = _distance
    fun updateBoxPosition(x: Float, y: Float) {
        _boxPosition.value = Pair(x, y)
        _text2.value = "(${x.roundToInt()}, ${y.roundToInt()})"
        updateDistance()

    }
    fun updateButtonPosition(x: Float, y: Float) {
        _buttonPosition.value = Pair(x, y)
        _text3.value = "(${x.roundToInt()}, ${y.roundToInt()})"

//        updateDistance()
    }

    fun updateButtonPositionInParent(x: Float, y: Float) {
        _buttonPositionInParent.value = Pair(x, y)
        _text1.value = "(${x.roundToInt()}, ${y.roundToInt()})"
        updateDistance()
    }

    fun resetButton() {
        _buttonPosition.value = Pair(0f, 0f)
        _buttonPositionInParent.value = Pair(0f, 0f)
        _text1.value = "(${0f.roundToInt()}, ${0f.roundToInt()})"
        updateDistance()
    }

    private fun updateDistance() {
        val boxPos = _boxPosition.value ?: return
        val buttonPos = _buttonPositionInParent.value ?: return
        val distance = sqrt((boxPos.first - buttonPos.first).pow(2) + (boxPos.second - buttonPos.second).pow(2))
        _distance.value = distance
        _text2.value = "${distance.roundToInt()}"
    }
}
