package com.cursojetpackcompose.jetpackcomposecatalogomio.movimientoBoton

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.abs

@HiltViewModel
class DragDropViewModel @Inject constructor() : ViewModel() {


    private val _buttonColors = listOf(
        MutableLiveData(Color.Green),
        MutableLiveData(Color.Blue),
        MutableLiveData(Color.Red),
        MutableLiveData(Color.Yellow),
        MutableLiveData(Color.Magenta)
    )
    val buttonColors: List<LiveData<Color>> = _buttonColors

    private val _buttonPositions = listOf(
        MutableLiveData(Offset.Zero),
        MutableLiveData(Offset.Zero),
        MutableLiveData(Offset.Zero),
        MutableLiveData(Offset.Zero),
        MutableLiveData(Offset.Zero)
    )
    val buttonPositions: List<LiveData<Offset>> = _buttonPositions

    fun updateButtonPosition(index: Int, newPosition: Offset) {
        Log.i("juanfran", "updateButtonPosition: $newPosition indice: $index")
        _buttonPositions[index].postValue(newPosition)
        checkIfNearBox(index)

    }

    fun resetButtonPosition(index: Int) {
        _buttonPositions[index].postValue(Offset.Zero)
    }

    fun resetTotalButtonPosition() {
        _buttonPositions.forEach { it.postValue(Offset.Zero) }
    }

    private fun checkIfNearBox(index: Int) {
        val boxPosition = Offset(200f, 200f)
        val threshold = 50f

        val position = _buttonPositions[index].value ?: return
        val color = _buttonColors[index].value ?: return

        val isNearBox = abs(position.x - boxPosition.x) < threshold &&
                abs(position.y - boxPosition.y) < threshold

        if (isNearBox) {
            _buttonPositions[index].postValue(if (color == _buttonColors[index].value) boxPosition else Offset.Zero)
        }
    }
}
