package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.dialogoTablasMultiplicar.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
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
                                onClick = { dialogoTablasViewModel.incrementarAciertos()},
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
                                onClick = { dialogoTablasViewModel.decrementarAciertos()},
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
                                onClick = {dialogoTablasViewModel.incrementarErrores() },
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
                                onClick = {dialogoTablasViewModel.decrementarErrores() },
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
            DialogoTablas(
                show = showDialogo.value,
                onDismiss = { dialogoTablasViewModel.changeDialogo(navigationController) },
                dialogoTablasViewModel = dialogoTablasViewModel
            )
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
                border = BorderStroke(4.dp, Color.LightGray)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.repasarSeleccion_dialogo_terminar),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        lineHeight = 32.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Divider(
                        Modifier
                            .background(Color.White)
                            .height(4.dp)
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        text = "${stringResource(id = R.string.repasarSeleccion_dialogo_aciertos)}: $correctas",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        lineHeight = 32.sp
                    )
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = "${stringResource(id = R.string.repasarSeleccion_dialogo_errores)}: $errores",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        lineHeight = 32.sp
                    )
                    Button(
                        onClick = {
//                            anunciosViewModel.getAdsRepasarSeleccion(activity)
                            onDismiss()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 38.dp),
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = BotonAzul,
                            contentColor = Color.White,
                        ),
                        border = BorderStroke(4.dp, Color.White)
                    ) {
                        Text(
                            text = stringResource(id = R.string.boton_dialogo),
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,

                            )
                    }
                }
            }

        }
    }
}

