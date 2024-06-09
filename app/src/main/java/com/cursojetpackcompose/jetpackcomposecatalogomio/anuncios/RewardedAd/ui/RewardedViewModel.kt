package com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.RewardedAd.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.MainActivity
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.TestAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RewardedViewModel @Inject constructor() : ViewModel() {
    val ADMOB = "AdMob"
    fun rewardedInterstitialAd(activity: MainActivity) {
        RewardedInterstitialAd.load(
            activity,
            TestAds.REWARDED_INTERSTITIAL_AD,
            AdRequest.Builder().build(),
            object : RewardedInterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.i(ADMOB, "Rewarded Interstitial onAdFailedToLoad: ${p0.message}")
                }

                override fun onAdLoaded(p0: RewardedInterstitialAd) {
                    super.onAdLoaded(p0)
                    p0.show(activity) {}
                }
            }

        )
    }

    fun rewardedTestAd(activity: MainActivity) {
        RewardedAd.load(
            activity,
            TestAds.REWARDED_AD,
            AdRequest.Builder().build(),
            object : RewardedAdLoadCallback() {
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.i(ADMOB, "Rewarded Ad onAdFailedToLoad: ${p0.message}")
                }

                override fun onAdLoaded(p0: RewardedAd) {
                    super.onAdLoaded(p0)
                    p0.show(activity) {}
                }
            }
        )
    }
}