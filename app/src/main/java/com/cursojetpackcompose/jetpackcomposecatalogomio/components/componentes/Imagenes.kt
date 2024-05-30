package com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.rounded.StarBorder
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cursojetpackcompose.jetpackcomposecatalogomio.R
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.JetpackComposeCatalogoMioTheme
import coil.compose.AsyncImage

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.batman),
        contentDescription = "Imagen",
        alpha = 0.7f,
        modifier = Modifier.size(150.dp)
    )

}

@Composable
fun MyImageOnline() {
    AsyncImage(
        model = "https://picsum.photos/id/1/200/300",
        contentDescription = "My Image",
        placeholder = painterResource(R.drawable.placeholder),
        modifier = Modifier.size(150.dp)
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.batman),
        contentDescription = "Imagen",
//        modifier = Modifier.clip(RoundedCornerShape(25f))
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Red, CircleShape),

    )

}
//https://fonts.google.com/icons todos los iconos que se van a usar
@Composable
fun MyIcons() {
    Icon(
        imageVector = Icons.Rounded.StarBorder,
        contentDescription = "Icono",
        tint = Color.Red,
        modifier = Modifier.size(150.dp)
    )
}


@Composable
fun GridComposable() {
    Column(
        //modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MyImage()
            MyImageOnline()
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MyImageAdvance()
            MyIcons()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewImage() {
    JetpackComposeCatalogoMioTheme {
        GridComposable()
    }
}