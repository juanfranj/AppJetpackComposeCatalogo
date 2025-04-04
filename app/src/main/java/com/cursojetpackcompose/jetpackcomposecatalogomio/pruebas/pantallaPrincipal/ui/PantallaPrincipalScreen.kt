package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.pantallaPrincipal.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.R

@Composable
fun PantallaPrincipalScreen(
    navigationController: NavHostController,
    pantallaPrincipalViewModel: PantallaPrincipalViewModel
) {
//    val tarjetas:List<String> = listOf("Estudiar", "Jugar", "Clasificacion", "Tienda", "Scroll Uno", "Scroll Dos")
    val tarjetas = pantallaPrincipalViewModel.tarjetas

    Scaffold (topBar = {
        TopAppBar(
            backgroundColor = Color(0xFF81D4FA),
            contentColor = Color.White,
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Gema recogida (izquierda)
                Image(
                    painter = painterResource(id = R.drawable.fb),
                    contentDescription = "Gemas acumuladas",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { /* Acción al hacer click en gema */ }
                )

                // Icono personalizado (derecha)
                Image(
                    painter = painterResource(id = R.drawable.zorropresentacion),
                    contentDescription = "Icono usuario",
                    modifier = Modifier
                        .size(48.dp)
                        .clickable { /* Acción al hacer click en icono */ }
                )
            }
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Fila 1: tarjetas scrolleables en horizontal con LazyRow
            LazyRow(
                modifier = Modifier
                    .weight(.65f)
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {

                itemsIndexed(tarjetas) { _, item ->
                    val (nombre, imagen) = item
                    BodyCard(
                        modifier = Modifier.fillMaxSize(),
                        navController = navigationController,
                        nombre = nombre,
                        nombreImagen = imagen
                    )
                }
            }
            Button(
                onClick = { navigationController.navigateUp() },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Text(text = "\uD83D\uDD19 Volver a pantalla de pruebas")
            }

            // Fila 2: imagen fija + botón
//            Column(
//                modifier = Modifier
//                    .weight(.35f)
//                    .wrapContentHeight()
//                    .padding(bottom = 16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.zorropresentacion),
//                    contentDescription = "Imagen de multiplicación",
//                    modifier = Modifier
//                        .fillMaxWidth(0.8f)
//                        .height(180.dp)
//                )

                //Spacer(modifier = Modifier.height(24.dp))

//                Button(
//                    onClick = { navigationController.navigateUp() },
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth(0.8f)
//                ) {
//                    Text(text = "\uD83D\uDD19 Volver a pantalla de pruebas")
//                }
//            }
        }
    }
}



@Composable
fun BodyCard(
    modifier: Modifier,
    navController: NavHostController,
    nombre: String,
    nombreImagen: String
) {
    val context = LocalContext.current
    val imagenId = remember(nombreImagen) {
        context.resources.getIdentifier(nombreImagen, "drawable", context.packageName)
    }

    Box(
        modifier = modifier
            .fillMaxWidth(),
            //.padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .width(300.dp)
                //.height(200.dp)
                .clickable { },
            shape = RoundedCornerShape(24.dp),
            contentColor = Color.White,
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                if (imagenId != 0) {
                    Image(
                        painter = painterResource(id = imagenId),
                        contentDescription = nombre,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}




