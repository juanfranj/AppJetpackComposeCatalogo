package com.cursojetpackcompose.jetpackcomposecatalogomio.layout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
fun HomeLayout(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderLayout(Modifier.align(Alignment.TopEnd), navigationController)
        BodyLayout(Modifier.align(Alignment.Center), navigationController)


    }
}

@Composable
fun BodyLayout(modifier: Modifier, navigationController: NavHostController) {
    Column(modifier = modifier) {
        Button(
            onClick = { navigationController.navigate(Routes.ComplexLayout.route) },
            modifier = Modifier.width(300.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Layout Complejo",
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        }

        Button(
            onClick = { navigationController.navigate(Routes.Components.route) },
            modifier = Modifier.width(300.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Constrais Layout", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }


    }
}

@Composable
fun HeaderLayout(modifier: Modifier, navigationController: NavHostController) {
    Icon(
        imageVector = Icons.Filled.ArrowBack,
        contentDescription = "Arrow Back",
        modifier = modifier
            .padding(16.dp)
            .size(30.dp)
            .clickable { navigationController.popBackStack() })

}
