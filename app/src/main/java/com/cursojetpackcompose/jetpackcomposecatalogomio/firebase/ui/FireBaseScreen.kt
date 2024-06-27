package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.ui

import androidx.compose.foundation.layout.*
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
fun FireBaseScreen(navigationController: NavHostController, firebaseViewModel: FireBaseViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navigationController.navigate(Routes.FireBaseAnalytics.route)},
            modifier = Modifier
                .width(300.dp)
                .padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Analytics", fontSize = MaterialTheme.typography.titleLarge.fontSize)

        }
        Button(
            onClick = { /* Acción para Crashlytics */ },
            modifier = Modifier
                .width(300.dp)
                .padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Crashlytics", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
        Button(
            onClick = { /* Acción para Notifications */ },
            modifier = Modifier
                .width(300.dp)
                .padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Notifications", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
        Button(
            onClick = { navigationController.navigate(Routes.RemoteConfig.route) },
            modifier = Modifier
                .width(300.dp)
                .padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "RemoteConfig", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navigationController.navigate(Routes.Home.route)},
            modifier = Modifier
                .width(300.dp)
                .padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Volver", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
    }
}
