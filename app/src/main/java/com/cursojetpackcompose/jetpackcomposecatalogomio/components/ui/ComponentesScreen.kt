package com.cursojetpackcompose.jetpackcomposecatalogomio.components.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.GridComposable
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.MyButtonExample
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.MyTextFieldAdvance
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.MyTextFieldOutlined
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes

@Composable
fun Components(navigationController: NavHostController, componentesViewModel: ComponentesViewModel) {
    val myText by componentesViewModel.mytext.observeAsState(initial = "")
    val myTextOutlined by componentesViewModel.mytextOutlined.observeAsState(initial = "")


    Column(
        modifier = Modifier
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = "Textfield", Modifier.padding(bottom = 8.dp))
        MyTextFieldAdvance(componentesViewModel, myText) {componentesViewModel.setMyText(it, myTextOutlined)}
        MyTextFieldOutlined() // Lo hago sin viewModel para probar el ejemplo
        Text(text = "Buttons", Modifier.padding(top = 8.dp))
        MyButtonExample()
        Text(text = "Image")
        GridComposable()
        Text(text = "Navegación Básica", Modifier.padding(top = 8.dp))
        ComeNavigation(navigationController = navigationController)

    }
}


@Composable
fun ComeNavigation(navigationController: NavHostController) {
    Column(
        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
    ) {
        Button(
            onClick = { navigationController.navigate(Routes.Home.route) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Volver a Home", fontSize = 24.sp)
        }
    }

}