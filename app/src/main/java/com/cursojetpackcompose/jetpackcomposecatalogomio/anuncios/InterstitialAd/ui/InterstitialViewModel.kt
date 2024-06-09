package com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.InterstitialAd.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.MainActivity
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.TestAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InterstitialViewModel @Inject constructor() : ViewModel() {

    val ADMOB = "AdMob"
    fun InterstitialTestAd(activity: MainActivity) {
        InterstitialAd.load(
            activity,
//        "ca-app-pub-3940256099942544/1033173712",
            TestAds.INTERSTITIAL_AD,
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.i(ADMOB, "onAdFailedToLoad: ${p0.message}")
                }

                override fun onAdLoaded(p0: InterstitialAd) {
                    super.onAdLoaded(p0)
                    Log.i(ADMOB, "onAdLoaded: ")
                    p0.show(activity)
                }
            }

        )

    }
}