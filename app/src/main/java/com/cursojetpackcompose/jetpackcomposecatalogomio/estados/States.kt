package com.cursojetpackcompose.jetpackcomposecatalogomio.estados

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.JetpackComposeCatalogoMioTheme

@Composable
fun MyStateExample() {

    var counter  by rememberSaveable{ mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }

        Text(text = "He sido pulsado ${counter} veces")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewEstados() {
    JetpackComposeCatalogoMioTheme {
        MyStateExample()
    }
}