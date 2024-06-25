package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallasPruebasScreen(navigationController: NavController) {
    Scaffold { conttenPadding ->
        Column(
            modifier = Modifier.padding(conttenPadding).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navigationController.navigate(Routes.DialogoAppMultiplicar.route) },
                modifier = Modifier.width(300.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = "Dialogo AppMultiplicar",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
            Button(
                onClick = { navigationController.navigate(Routes.ValorarApp.route) },
                modifier = Modifier.width(300.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = "Valorar App",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navigationController.navigate(Routes.Home.route) },
                modifier = Modifier.width(300.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = "Volver",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
        }

    }
}