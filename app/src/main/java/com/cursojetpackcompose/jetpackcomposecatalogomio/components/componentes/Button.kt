package com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes

import android.content.res.Resources
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cursojetpackcompose.jetpackcomposecatalogomio.R
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.JetpackComposeCatalogoMioTheme
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.VerdeClaro

@Composable
fun MyButtonExample() {

    var enabled: Boolean by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        Modifier
            .padding(8.dp)
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = VerdeClaro,
                contentColor = Color.Blue
            ),
            border = BorderStroke(2.dp, Color.Green),
            modifier = Modifier.width(300.dp)
        ) {
            Text(text = "Boton", fontSize = 16.sp)
        }
        OutlinedButton(
            onClick = { /*TODO*/ }, modifier = Modifier
                .padding(top = 8.dp)
                .width(300.dp),
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = VerdeClaro,
                contentColor = Color.Blue,
                disabledContainerColor = Color.Yellow,
            ),

            ) {
            Text(text = "OutlinedButton", fontSize = 16.sp)
        }
        TextButton(
            onClick = { enabled = !enabled },
            enabled = true,
            modifier = Modifier.width(300.dp)
        ) {
            if (enabled) {
                Text(text = "TextButton Enabled == true", fontSize = 16.sp)
            } else {
                Text(text = "TextButton Enabled == false", fontSize = 16.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreviewButton() {
    JetpackComposeCatalogoMioTheme {
        MyButtonExample()
    }
}