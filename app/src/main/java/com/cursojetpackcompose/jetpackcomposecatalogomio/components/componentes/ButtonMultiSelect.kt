package com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.layout.ui.GitHubIcon
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes


@Composable
fun MultiSelectableButton(
    navigationController: NavHostController,
    detailButtonMultiSelectViewModel: DetailButtonMultiSelectViewModel
) {
    val options = listOf(
        "Tabla del 2",
        "Tabla del 3",
        "Tabla del 4",
        "Tabla del 5",
        "Tabla del 6",
        "Tabla del 7",
        "Tabla del 8",
        "Tabla del 9",
        "Tabla del 10"
    )
    //val selectedOptions = remember { mutableStateListOf<String>() }
    val selectedOptions by remember { mutableStateOf(detailButtonMultiSelectViewModel.selectedItems) }

    val githubRepoUrl =
        "https://github.com/juanfranj/AppJetpackComposeCatalogo/blob/main/app/src/main/java/com/cursojetpackcompose/jetpackcomposecatalogomio/components/componentes/ButtonMultiSelect.kt"
    Box(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
        Row(Modifier.padding(bottom = 16.dp)) {
            GitHubIcon(githubRepoUrl = githubRepoUrl)
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            options.forEach { option ->
                MultiSelectableButton(
                    text = option,
                    isSelected = selectedOptions.contains(option),
                    onSelectedChange = { isSelected ->
                        if (isSelected) {
                            //selectedOptions.add(option)
                            detailButtonMultiSelectViewModel.setSelectedItems(option)
                        } else {
                            //selectedOptions.remove(option)
                            detailButtonMultiSelectViewModel.removeSelectedItems(option)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Button(
                onClick = {
                    //detailButtonMultiSelectViewModel.setItems(selectedOptions.toString())
                    navigationController.navigate(Routes.DetailBotonMultiseleccion.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Comenzar", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }
            Button(
                onClick = {
                    detailButtonMultiSelectViewModel.clearSelectedItems()
                    navigationController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Volver", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }
            Text(text = "Los botones seleccionados son: ${selectedOptions.joinToString()}")
        }
    }
}

@Composable
fun MultiSelectableButton(
    text: String,
    isSelected: Boolean,
    onSelectedChange: (Boolean) -> Unit
) {
    Button(
        onClick = { onSelectedChange(!isSelected) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color.Green else Color.Gray,
            contentColor = Color.White
        ),
        shape = CircleShape,
        modifier = Modifier
            .padding(4.dp)
            .height(50.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApp()
//}