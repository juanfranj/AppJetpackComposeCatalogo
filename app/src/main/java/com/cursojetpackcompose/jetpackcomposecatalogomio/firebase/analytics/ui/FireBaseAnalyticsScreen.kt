package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.analytics.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes

@Composable
fun FireBaseAnalyticsScreen(
    navigationController: NavHostController,
    firebaseAnalyticsViewModel: FireBaseAnalyticsViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                firebaseAnalyticsViewModel.onAnalyticsButtonClick()
                firebaseAnalyticsViewModel.onLoginSelected() },
            modifier = Modifier.width(300.dp).padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Ejecutar Evento", fontSize = MaterialTheme.typography.titleLarge.fontSize)

        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navigationController.navigate(Routes.FireBase.route) },
            modifier = Modifier.width(300.dp).padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Volver", fontSize = MaterialTheme.typography.titleLarge.fontSize)

        }
    }
}
