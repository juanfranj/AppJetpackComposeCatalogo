package com.cursojetpackcompose.jetpackcomposecatalogomio.layout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.JetpackComposeCatalogoMioTheme

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .background(Color.Cyan)
            .verticalScroll(
                rememberScrollState()
            ), contentAlignment = Alignment.TopStart) {
            Text(text = "Esto es un ejemplo, Hola que pasa colega")

        }

    }
}

@Composable
fun MyColumn(){
    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween){
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 2", modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 3", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 4", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 5", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(100.dp))

    }

}

@Composable
fun MyRow(){
    Row (
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Cyan)
            .width(100.dp)
            )
        Text(text = "Ejemplo 2", modifier = Modifier
            .background(Color.Gray)
            .width(100.dp)
            )
        Text(text = "Ejemplo 3", modifier = Modifier
            .background(Color.Red)
            .width(100.dp)
            )
        Text(text = "Ejemplo 4", modifier = Modifier
            .background(Color.Yellow)
            .width(100.dp)
            )
        Text(text = "Ejemplo 5", modifier = Modifier
            .background(Color.Green)
            .width(100.dp)
            )
        Text(text = "Ejemplo 6", modifier = Modifier
            .background(Color.Magenta)
            .width(100.dp)
        )

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreviewLayout() {
    JetpackComposeCatalogoMioTheme {
        MyColumn()
    }
}