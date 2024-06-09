package com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.InterstitialAd.ui

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
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyInterstitialAd(
    activity: MainActivity,
    navigationController: NavHostController,
    interstitialViewModel: InterstitialViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Interstitial Ad") },
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
                text = "Pantalla Ejemplo InterstitialAds",
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = {
                    interstitialViewModel.InterstitialTestAd(activity)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Interstitial Ad",
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


//const val ADMOB = "AdMob"


//fun InterstitialTestAd(activity: MainActivity) {
//    InterstitialAd.load(
//        activity,
////        "ca-app-pub-3940256099942544/1033173712",
//        TestAds.INTERSTITIAL_AD,
//        AdRequest.Builder().build(),
//        object : InterstitialAdLoadCallback() {
//            override fun onAdFailedToLoad(p0: LoadAdError) {
//                super.onAdFailedToLoad(p0)
//                Log.i(ADMOB, "onAdFailedToLoad: ${p0.message}")
//            }
//
//            override fun onAdLoaded(p0: InterstitialAd) {
//                super.onAdLoaded(p0)
//                Log.i(ADMOB, "onAdLoaded: ")
//                p0.show(activity)
//            }
//        }
//
//    )
//
//}