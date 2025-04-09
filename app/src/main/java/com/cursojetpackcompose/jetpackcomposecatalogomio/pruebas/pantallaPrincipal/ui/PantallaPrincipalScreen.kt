package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.pantallaPrincipal.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
    val gemas = pantallaPrincipalViewModel.gemas
    val iconos = pantallaPrincipalViewModel.iconos

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFFFFFBF4),//Color(0xFFFFCC00),
                contentColor = Color.White,
                elevation = 0.dp
            ) {
                Column(Modifier.fillMaxWidth()) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            // Gema recogida (izquierda)
                            Image(
                                painter = painterResource(id = R.drawable.icon_gema_azul),
                                contentDescription = "Gemas acumuladas",
                                modifier = Modifier
                                    .size(42.dp)
//                                    .clickable { /* Acción al hacer click en gema */ }
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = gemas.toString(),
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 24.sp,
                                color = Color(0xFF00AEEF), // color azul vibrante como en la imagen
                                letterSpacing = (0.5).sp
                            )
                        }

                        // Icono personalizado (derecha)
                        Image(
                            painter = painterResource(id = R.drawable.icon_zorro),
                            contentDescription = "Icono Zorro",
                            modifier = Modifier
                                .size(56.dp)
                                .clickable { navigationController.navigateUp() }
                        )
                    }

                }
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color(0xFFFFFBF4),
//                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
//                elevation = 0.dp,
                contentPadding = PaddingValues(0.dp),
                elevation = 8.dp
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Divider(
                        color = Color(0xFFCCCCCC),
                        thickness = 3.dp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        iconos.forEach { iconName ->
                            val context = LocalContext.current
                            val iconResId = remember(iconName) {
                                context.resources.getIdentifier(
                                    iconName,
                                    "drawable",
                                    context.packageName
                                )
                            }
                            if (iconResId != 0) {
                                Image(
                                    painter = painterResource(id = iconResId),
                                    contentDescription = iconName,
                                    modifier = Modifier
                                        .size(56.dp)
                                        .clickable { /* Acción por definir */ }
                                )
                            }
                        }
                    }
                }
            }
        }) { paddingValues ->
        Column(
            modifier = Modifier
                .background(Color(0xFFFFFBF4))
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
    )
    {
        Card(
            modifier = Modifier
                .width(256.dp)
                .height(384.dp)
                .clickable { },
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
            //contentColor = Color(0xFFFFFBF4),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFFBF4))
            ) {
                if (imagenId != 0) {
                    Image(
                        painter = painterResource(id = imagenId),
                        contentDescription = nombre,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

