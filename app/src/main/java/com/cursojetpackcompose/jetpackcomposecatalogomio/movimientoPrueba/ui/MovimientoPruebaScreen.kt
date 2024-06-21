package com.cursojetpackcompose.jetpackcomposecatalogomio.movimientoPrueba.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toOffset
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovimientoPrueba(
    navigationController: NavController,
    movimientoPruebaViewModel: MovimientoPruebaViewModel
) {
    val boxPosition by movimientoPruebaViewModel.boxPosition.observeAsState(initial = Pair(0f, 0f))
    val text1 by movimientoPruebaViewModel.text1.observeAsState("Texto 1")
    val text2 by movimientoPruebaViewModel.text2.observeAsState("Texto 2")
    val text3 by movimientoPruebaViewModel.text3.observeAsState("Texto 3")
    val buttonPosition by movimientoPruebaViewModel.buttonPosition.observeAsState(
        initial = Pair(
            0f,
            0f
        )
    )
    val buttonPositionInParent by movimientoPruebaViewModel.buttonPositionInParent.observeAsState(
        initial = Pair(
            0f,
            0f
        )
    )
    val distance by movimientoPruebaViewModel.distance.observeAsState(0f)
    var showDialog by remember { mutableStateOf(false) }

    val closeDistanceThreshold = 200f // Define the threshold for proximity

    LaunchedEffect(distance) {
        if (distance < closeDistanceThreshold) {
            showDialog = false
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Prueba Superada") },
            text = { Text("Has acercado el botón al cuadro. ¡Prueba superada!") },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    movimientoPruebaViewModel.resetButton()
                }) {
                    Text("OK")
                }
            }
        )
    }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val animatedOffsetX = remember { Animatable(0f) }
            val animatedOffsetY = remember { Animatable(0f) }
            val coroutineScope = rememberCoroutineScope()
            val animatedOffset = remember { Animatable(Offset.Zero, Offset.VectorConverter) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Movimiento Prueba",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 32.dp),
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Coloca el Boton en su color",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .size(75.dp)
                            .background(Color.Blue.copy(alpha = 0.75f))
                            .onGloballyPositioned { coordinates ->
                                val position = coordinates.positionInWindow()
//                                val position = coordinates.positionInRoot()
                                movimientoPruebaViewModel.updateBoxPosition(position.x, position.y)

                            }
                    )
                }
                Spacer(modifier = Modifier.height(72.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Posicion Boton Parent: ",
                            fontSize = 16.sp
                        )
                        Text(
                            text = text1,
                            fontSize = 16.sp
                        )
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Posicion Box",
                            fontSize = 16.sp
                        )
                        Text(
                            text = "(${boxPosition.first.roundToInt()}, ${boxPosition.second.roundToInt()}) ",
                            fontSize = 16.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Distancia Box ",
                            fontSize = 16.sp
                        )
                        Text(
                            text = text2,
                            fontSize = 16.sp
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Posicion Boton ",
                            fontSize = 16.sp
                        )
                        Text(
                            text = text3,
                            fontSize = 16.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .offset {
                            IntOffset(
                                animatedOffset.value.x.roundToInt(),
                                animatedOffset.value.y.roundToInt()
                            )
                        }
                        .pointerInput(Unit) {
                            detectDragGestures(
                                onDragEnd = {
                                    coroutineScope.launch {
                                        if (distance <= closeDistanceThreshold) {
                                            val offsetX = boxPosition.first - buttonPositionInParent.first
                                            val offsetY = boxPosition.second - buttonPositionInParent.second

                                            // Iniciar la animación hacia la posición de ajuste
                                            animatedOffset.animateTo(
                                                Offset(animatedOffset.value.x + offsetX, animatedOffset.value.y + offsetY),
                                                animationSpec = tween(durationMillis = 200) // Aumenta la duración para hacerlo más lento
                                            )

                                            movimientoPruebaViewModel.updateButtonPosition(
                                                buttonPosition.first + offsetX,
                                                buttonPosition.second + offsetY
                                            )
                                        } else {
                                            movimientoPruebaViewModel.resetButton()
                                            animatedOffset.animateTo(
                                                Offset.Zero,
                                                animationSpec = tween(durationMillis = 650) // Aumenta la duración para hacerlo más lento
                                            )
                                        }
                                    }
                                },

                                onDrag = { change, dragAmount ->
                                    change.consume()
                                    coroutineScope.launch {
                                        animatedOffset.snapTo(
                                            Offset(
                                                animatedOffset.value.x + dragAmount.x,
                                                animatedOffset.value.y + dragAmount.y
                                            )
                                        )
                                    }
                                }
                            )
                        }

                        .size(75.dp)
                        .background(Color.Blue)
                        .onGloballyPositioned { coordinates ->
                            val position = coordinates.positionInWindow()
                            movimientoPruebaViewModel.updateButtonPositionInParent(
                                position.x,
                                position.y
                            )
                        }


                ) {
                    Text(
                        text = "Num",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Movimiento Relativo",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "( ${boxPosition.first.roundToInt()}, ${boxPosition.second.roundToInt()}) - ( ${buttonPositionInParent.first.roundToInt()}, ${buttonPositionInParent.second.roundToInt()}) = ( ${(boxPosition.first - buttonPositionInParent.first).roundToInt()}, ${(boxPosition.second - buttonPositionInParent.second).roundToInt()})",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        movimientoPruebaViewModel.resetButton()
                        navigationController.navigate(Routes.Home.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Volver")
                }
            }
        }
    }
}
