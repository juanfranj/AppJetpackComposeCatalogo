package com.cursojetpackcompose.jetpackcomposecatalogomio.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.GridComposable
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.MyButtonExample
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.MyTextFieldAdvance
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.MyTextFieldOutlined
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes

@Composable
fun Home(navigationController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navigationController.navigate(Routes.Pantalla2.route) },
            modifier = Modifier.width(300.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Navegación",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        }

        Button(
            onClick = { navigationController.navigate(Routes.Components.route) },
            modifier = Modifier.width(300.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Componentes", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }

        Button(
            onClick = { navigationController.navigate(Routes.Layout.route) },
            modifier = Modifier.width(300.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Layouts", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }

        Button(
            onClick = { navigationController.navigate(Routes.Instagram.route) },
            modifier = Modifier.width(300.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Ejemplo Instagram", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }

        Button(
            onClick = { navigationController.navigate(Routes.BotonMultiseleccion.route) },
            modifier = Modifier.width(300.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Boton Multiseleccionable", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
    }
}

