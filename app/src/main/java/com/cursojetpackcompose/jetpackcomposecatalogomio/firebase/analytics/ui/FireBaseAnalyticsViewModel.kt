package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.analytics.ui

import androidx.lifecycle.ViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.analytics.data.AnalyticsManager
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.analytics.data.model.AnalyticModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FireBaseAnalyticsViewModel @Inject constructor(private val analyticsManager: AnalyticsManager): ViewModel(){
    fun onLoginSelected() {
        val analyticModel = AnalyticModel(title = "Nuevo evento de dia", analyticsString = listOf(Pair("clave", "valor")))
        analyticsManager.sendEvent(analyticModel)
//        analyticsManager.example()
    }

    fun onAnalyticsButtonClick() {
        analyticsManager.logButtonPressEvent("Analytics")
    }


}