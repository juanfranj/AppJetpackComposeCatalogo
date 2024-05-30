package com.cursojetpackcompose.jetpackcomposecatalogomio.layout.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.JetpackComposeCatalogoMioTheme

@Composable
fun MyComplexLayout(){
    Column (Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)) {

        }
        MySpace(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box (modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red))
            Box (modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green),
                contentAlignment = Alignment.Center) {
                Text(text = "Hola Soy Juanfran")
            }

        }
        MySpace(size = 30)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)) {

        }
    }
}

@Composable
fun MySpace(size:Int){
    Spacer(modifier = Modifier.height(size.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogoMioTheme {
        MyComplexLayout()
    }
}