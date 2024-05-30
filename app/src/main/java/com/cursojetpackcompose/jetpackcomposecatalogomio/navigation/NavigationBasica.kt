package com.cursojetpackcompose.jetpackcomposecatalogomio.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes.*


//Navegacion sin sealed class basica
//Incluir en el setContent del MainActivity
//val navigationController = rememberNavController()
//NavHost(navController = navigationController, startDestination = "pantalla1") {
//    composable(route = "pantalla1") { Screen1(navigationController) }
//    composable(route = "pantalla2") { Screen2(navigationController) }
//    composable(route = "pantalla3") { Screen3(navigationController) }
//}


//Navegacion con sealed Class
//val navigationController = rememberNavController()
//NavHost(navController = navigationController, startDestination = Routes.Pantalla1.route) {
//    composable(route = Routes.Pantalla1.route) { Screen1(navigationController) }
//    composable(route = Routes.Pantalla2.route) { Screen2(navigationController) }
//    composable(route = Routes.Pantalla3.route) { Screen3(navigationController) }
//
//}



@Composable
fun Screen2(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Pantalla Dos",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Pantalla3.route) })
    }
}

@Composable
fun Screen3(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = "Pantalla Tres",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navigationController.navigate(Pantalla4.createRoute(4))})
    }
}

@Composable
fun Screen4(navigationController: NavHostController, age: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pantalla Cuatro, Pantalla = $age",
            modifier = Modifier
                .clickable { navigationController.navigate(Pantalla5.createRoute("Juanfran")) }
                .padding(24.dp))
        Button(onClick = { navigationController.navigate(Pantalla5.createRoute("Juanfran") )}) {
            Text(text = "Ir a Pantalla Cinco")
        }
    }
}


@Composable
fun Screen5(navigationController: NavHostController, name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pantalla Cinco, Me llamo $name, Sin mandar variable",
            modifier = Modifier
                .clickable { navigationController.navigate("pantalla6") }
                .padding(24.dp))
        Button(onClick = { navigationController.navigate(Pantalla6.createRoute("Verdadero")) }) {
            Text(text = "Ir a Pantalla 6 con variable Verdadero")
        }
    }
}

@Composable
fun Screen6(navigationController: NavHostController, name: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Variable Opcional : $name",
            modifier = Modifier
                .clickable { navigationController.navigate(Home.route) }
                .padding(24.dp))
        Button(onClick = { navigationController.navigate(Home.route) }) {
            Text(text = "Home")
        }
    }
}