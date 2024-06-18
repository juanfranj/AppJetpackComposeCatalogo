package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.analytics.data

import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.analytics.data.model.AnalyticModel
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import javax.inject.Inject

class AnalyticsManager @Inject constructor(private val analytics: FirebaseAnalytics) {

    fun example() {
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN) {
            param(FirebaseAnalytics.Param.SCORE, "100")
        }
    }

    fun example2() {
        analytics.logEvent("juanfranj") {
            param("super", 100)
            param("name", "juanfranj")
        }
    }

    fun logButtonPressEvent(buttonName: String) {
        analytics.logEvent("button_press") {
            param("button_name", buttonName)
        }
    }

    fun sendEvent(analyticModel: AnalyticModel) {
        analytics.logEvent(analyticModel.title) {
            analyticModel.analyticsString.map { param(it.first, it.second) }
            analyticModel.analyticsDouble.map { param(it.first, it.second) }
            analyticModel.analyticsBundle.map { param(it.first, it.second) }
            analyticModel.analyticsLong.map { param(it.first, it.second) }
            analyticModel.analyticsBundleArray.map { param(it.first, it.second) }

        }

    }

}