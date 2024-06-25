package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.dialogoTablasMultiplicar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.cursojetpackcompose.jetpackcomposecatalogomio.R
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.BotonAzul
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.TituloCard
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.cardPresentation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogoTablasScreen(
    navigationController: NavController,
    dialogoTablasViewModel: DialogoTablasViewModel
) {

    val showDialogo = dialogoTablasViewModel.showDialogo.observeAsState(initial = false)
    val correctas by dialogoTablasViewModel.correctas.observeAsState(0)
    val errores by dialogoTablasViewModel.errores.observeAsState(0)

    Scaffold { conttenpadding ->
        Column(
            modifier = Modifier
                .padding(conttenpadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    dialogoTablasViewModel.changeDialogo(navigationController)
                },
                modifier = Modifier
                    .padding(vertical = 32.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = "Mostrar Dialogo",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
            Row(Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .background(Color.LightGray.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Aciertos",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                        color = Color.Blue,
                        fontSize = 24.sp,
                    )
                    Text(
                        text = "$correctas",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                        color = Color.Blue,
                        fontSize = 24.sp,
                    )

                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            IconButton(
                                onClick = { dialogoTablasViewModel.incrementarAciertos() },
                                modifier = Modifier
                                    .background(Color.Blue, RoundedCornerShape(8.dp))
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Decrement",
                                    tint = Color.White
                                )
                            }
                            IconButton(
                                onClick = { dialogoTablasViewModel.decrementarAciertos() },
                                modifier = Modifier
                                    .background(Color.Blue, RoundedCornerShape(8.dp))
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Remove,
                                    contentDescription = "Increment",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .background(Color.LightGray.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Errores",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                        color = Color.Blue,
                        fontSize = 24.sp,
                    )
                    Text(
                        text = "$errores",
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
                        color = Color.Blue,
                        fontSize = 24.sp,
                    )
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            IconButton(
                                onClick = { dialogoTablasViewModel.incrementarErrores() },
                                modifier = Modifier
                                    .background(Color.Blue, RoundedCornerShape(8.dp))
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Decrement",
                                    tint = Color.White
                                )
                            }
                            IconButton(
                                onClick = { dialogoTablasViewModel.decrementarErrores() },
                                modifier = Modifier
                                    .background(Color.Blue, RoundedCornerShape(8.dp))
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Remove,
                                    contentDescription = "Increment",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = if (showDialogo.value == true) "Mostrando Dialogo" else "Ocultando Diálogo",
                modifier = Modifier.padding(16.dp),
                color = Color.Blue,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
//                textAlign =  TextAlign.Center

            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    navigationController.navigate(Routes.PantallaPrueba.route)
                },
                modifier = Modifier
                    .padding(vertical = 32.dp, horizontal = 16.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(
                    text = "Volver",
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            }
            if (showDialogo.value == true) {
                DialogoTablas(
                    show = showDialogo.value,
                    onDismiss = { dialogoTablasViewModel.changeDialogo(navigationController) },
                    dialogoTablasViewModel = dialogoTablasViewModel
                )
            }

        }

    }
}

@Composable
fun DialogoTablas(
    show: Boolean,
    onDismiss: () -> Unit,
    dialogoTablasViewModel: DialogoTablasViewModel,
//                  activity: MainActivity,
//                  anunciosViewModel: AnunciosViewModel,

) {
    val correctas by dialogoTablasViewModel.correctas.observeAsState(0)
    val errores by dialogoTablasViewModel.errores.observeAsState(0)
    val coroutineScope = rememberCoroutineScope()

    if (show) {
        Dialog(
            onDismissRequest = {
                onDismiss()
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = TituloCard,
                    contentColor = Color.White
                ),
                border = BorderStroke(2.dp, Color.White)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextoCabecera(Arrangement.Center)
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(
                        Modifier
                            .background(Color.White)
                            .height(2.dp)
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
//                    Spacer(modifier = Modifier.height(16.dp))
                    TopBar(contadorRojo = errores, contadorVerde = correctas)
//                    Spacer(modifier = Modifier.height(16.dp))
                    ResultadoBox(
                        contadorRojo = errores,
                        contadorVerde = correctas,
                        dialogoTablasViewModel = dialogoTablasViewModel
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Body(onDismiss)

                }
            }

        }
    }
}

@Composable
fun ResultadoBox(
    contadorRojo: Int,
    contadorVerde: Int,
    dialogoTablasViewModel: DialogoTablasViewModel
) {
    val estrellas = dialogoTablasViewModel.obtenerNumeroEstrellas(contadorVerde, contadorRojo)

    Box(
        modifier = Modifier
            .background(cardPresentation, RoundedCornerShape(8.dp))
            .border(2.dp, Color.White, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = dialogoTablasViewModel.obtenerTextoNota(contadorVerde, contadorRojo),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
            )
            Estrellas(estrellas = estrellas)
        }
    }
}

@Composable
fun Body(onDismiss: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
//                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
//            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { /* Acción de repetir */ },
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f),
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = BotonAzul,
                    contentColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.White)
            ) {
                Text(
                    text = stringResource(id = R.string.Boton_repetir),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                    textAlign = TextAlign.Center
                )
            }
            Button(
                onClick = { onDismiss() },
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f),
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = BotonAzul,
                    contentColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.White)
            ) {
                Text(
                    text = stringResource(id = R.string.Boton_menu),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                    textAlign = TextAlign.Center
                )
            }
//            Spacer(modifier = Modifier.weight(1f))
        }

        Button(
            onClick = { /* Acción de valorar la app */ }, modifier = Modifier
                .padding(4.dp),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFD700),
                contentColor = Color.White,
            ),
            border = BorderStroke(2.dp, BotonAzul)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.Boton_valorar),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                    textAlign = TextAlign.Center,
                    color = BotonAzul
                )
                Spacer(modifier = Modifier.width(8.dp))
                repeat(5) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.star_on),
                        contentDescription = "Estrella",
                        tint = BotonAzul, // Color dorado
                        modifier = Modifier.size(16.dp) // Tamaño de las estrellas
                    )
                }
            }
        }

    }
}


@Composable
fun Estrellas(estrellas: Int) {

    Row(Modifier.padding(top = 24.dp)) {
        repeat(4) { index ->
            val color = if (index < estrellas) Color(0xFFFFD700) else Color.Gray
            Icon(
                painter = painterResource(id = android.R.drawable.star_on),
                contentDescription = null,
                tint = color,
                modifier = Modifier
                    .padding(8.dp)
                    .size(42.dp),
            )
        }
    }
}

@Composable
fun TextoCabecera(center: Arrangement.HorizontalOrVertical) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray.copy(alpha = 0.5f))
            .border(2.dp, Color.White, RoundedCornerShape(8.dp)),
        verticalArrangement = center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = stringResource(id = R.string.repasarSeleccion_dialogo_terminar),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            lineHeight = 32.sp
        )
    }


}

@Composable
fun TopBar(contadorRojo: Int, contadorVerde: Int) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = TituloCard,
        ),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {},
//                modifier = Modifier.size(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF228A76),
                    contentColor = Color.White
                ),
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(2.dp, Color.White),
                enabled = true // Botón deshabilitado
            ) {
                Text(
                    text = "$contadorVerde", fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {},
//                modifier = Modifier.size(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFCF483E),
                    contentColor = Color.White
                ),
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(2.dp, Color.White),
                enabled = true // Botón deshabilitado
            ) {
                Text(
                    text = "$contadorRojo", fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}




