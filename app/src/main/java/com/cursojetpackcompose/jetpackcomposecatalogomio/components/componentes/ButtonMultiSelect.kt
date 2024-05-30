package com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun MultiSelectableButton(navigationController: NavHostController) {
    val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    val selectedOptions = remember { mutableStateListOf<String>() }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        options.forEach { option ->
            MultiSelectableButton(
                text = option,
                isSelected = selectedOptions.contains(option),
                onSelectedChange = { isSelected ->
                    if (isSelected) {
                        selectedOptions.add(option)
                    } else {
                        selectedOptions.remove(option)
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Button(
            onClick = { navigationController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(50.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Volver", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
        Text(text = "Los botones seleccionados son: ${selectedOptions.joinToString()}")
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
            .padding(8.dp)
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