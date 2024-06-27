package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.domain

import android.util.Log
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.data.Repository
import javax.inject.Inject

class CanAccessToApp @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke():Boolean {
        val minVersionAllowed = repository.getMinAllowedVersion()
        val appVersion = repository.getAppVersion()
        Log.i("juanfran", "appVersion: $appVersion minVersionAllowed: $minVersionAllowed")

        return appVersion.zip(minVersionAllowed).all { (appV, minV) ->
            appV >= minV
        }

    }
}