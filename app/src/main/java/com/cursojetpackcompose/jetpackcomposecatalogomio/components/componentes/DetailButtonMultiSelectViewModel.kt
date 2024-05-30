package com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class DetailButtonMultiSelectViewModel : ViewModel() {
//    private val _items = mutableStateListOf<String>()
//    val items: List<String> = _items

    private val _selectedItems = mutableStateListOf<String>()
    val selectedItems: List<String> = _selectedItems

    fun setSelectedItems(item: String) {
        _selectedItems.add(item)
    }
    fun removeSelectedItems(item: String) {
        _selectedItems.remove(item)
    }
    fun clearSelectedItems() {
        _selectedItems.clear()
    }



}