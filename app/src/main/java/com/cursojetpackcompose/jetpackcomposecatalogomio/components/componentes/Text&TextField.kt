package com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.ui.ComponentesViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.JetpackComposeCatalogoMioTheme

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un Ejemplo")
        Text(
            text = "Hello World ",
            color = Color.Red,
            fontSize = 32.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas id ligula vel mi consectetur gravida at a nulla. Aenean finibus pretium imperdiet. Proin varius quam ultrices magna imperdiet, sed facilisis nisl aliquet. Nam blandit nunc id nisl rutrum, id pharetra quam sollicitudin. Integer porttitor eros id tellus varius accumsan. Nam vel sem quis erat sollicitudin dapibus rutrum at diam. Phasellus ac ante ut lacus aliquam dapibus in at ante. Phasellus pellentesque consequat maximus.",
            letterSpacing = 3.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center,
            lineHeight = 25.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 3
        )
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by rememberSaveable {
        mutableStateOf("")
    }

    TextField(
        value = myText,
        onValueChange = { myText = it }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance(componentsViewModel: ComponentesViewModel, myText:String,  onTextChange:(String) -> Unit) {
//    var myText by rememberSaveable {
//        mutableStateOf("")
//    }
    TextField(
        modifier = Modifier.padding(8.dp),
        value = myText,
        onValueChange = {
            onTextChange(it)
        },
        label = { Text(text = "Introduce tu nombre") },
        singleLine = true,
        maxLines = 1,
        placeholder = { Text(text = "Introduce tu nombre") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
    var myText by rememberSaveable {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier.padding(8.dp),
        value = myText,
        onValueChange = { myText = it },
        label = {
            Text(text = "Hola Carabola")
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        ),
        singleLine = true,
        maxLines = 1,
        placeholder = { Text(text = "Introduce tu nombre") })
}




//@Preview(showBackground = true)
//@Composable
//fun GreetingPreviewText() {
//    JetpackComposeCatalogoMioTheme {
//        MyTextFieldAdvance(loginViewModel)
//    }
//}