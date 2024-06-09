package com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.RewardedAd.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.MainActivity
import com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.InterstitialAd.ui.InterstitialTestAd
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.TestAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRewardedAd(activity: MainActivity, navigationController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Rewarded Ad") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Pantalla Ejemplo RewardedAd",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = {
                    rewardedTestAd(activity)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Rewarded Ad",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = {
                    rewardedInterstitialAd(activity)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Rewarded Interstitial Ad",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    navigationController.navigate(Routes.Anuncios.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Volver Anuncios",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
        }
    }
}


const val ADMOB = "AdMob"

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