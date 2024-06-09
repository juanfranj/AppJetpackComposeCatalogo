package com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.BannerAd.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.TestAds
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBannerScreen(navigationController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "My Banner Screen") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )

        },
//        bottomBar = { BannerAd(Modifier.fillMaxWidth()) }

        ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BannerAd(modifier = Modifier.padding(it))
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Pantalla Ejemplo de un Banner",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    navigationController.navigate(Routes.Anuncios.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Volver",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
            BannerAd(modifier = Modifier.padding(2.dp))
        }


    }
}


@Composable
fun BannerAd(modifier: Modifier) {
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdSize.BANNER)
//                adUnitId = "ca-app-pub-3940256099942544/9214589741"
                adUnitId = TestAds.BANNER_AD
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}