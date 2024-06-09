package com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes


@Composable
fun MyAnuncios(navigationController: NavHostController, anunciosViewModel: AnunciosViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        MyAnunciosButton(
            name = "Banner",
            route = Routes.Banner.route,
            navigationController = navigationController,
            anunciosViewModel = anunciosViewModel,
        )
        MyAnunciosButton(
            name = "Interstitial",
            route = Routes.Interstitial.route,
            navigationController = navigationController,
            anunciosViewModel = anunciosViewModel,
        )
        MyAnunciosButton(
            name = "Rewarded" ,
            route = Routes.Rewarded.route,
            navigationController = navigationController,
            anunciosViewModel = anunciosViewModel,
        )
        Spacer(modifier = Modifier.weight(1f))
        MyAnunciosButton(
            name = "Volver",
            route = Routes.Home.route,
            navigationController = navigationController,
            anunciosViewModel = anunciosViewModel,
        )

    }
}

@Composable
fun MyAnunciosButton(
    name: String,
    navigationController: NavHostController,
    anunciosViewModel: AnunciosViewModel,
    route: String
) {
    Button(
        onClick = {
            if (route != " ") {
                navigationController.navigate(route)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = name,
            fontSize = MaterialTheme.typography.titleLarge.fontSize
        )
    }
}