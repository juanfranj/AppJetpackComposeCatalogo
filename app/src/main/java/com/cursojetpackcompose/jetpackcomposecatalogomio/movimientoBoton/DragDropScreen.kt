package com.cursojetpackcompose.jetpackcomposecatalogomio.movimientoBoton

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DragDropScreen(viewModel: DragDropViewModel, navigationController: NavHostController) {
//    val boxColor by viewModel.boxColor.observeAsState(Color(0x8000FF00))

    val buttonColors = viewModel.buttonColors.map { it.observeAsState(Color.Gray) }
    val buttonPositions = viewModel.buttonPositions.map { it.observeAsState(Offset.Zero) }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "App Prueba",
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp,
                modifier = Modifier.padding(16.dp),
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(56.dp))
            Column {
                buttonColors.forEachIndexed { index, colorState ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Coloca el Boton en su lugar",
                            modifier = Modifier
                                .background(colorState.value.copy(alpha = 0.5f))
                                .padding(16.dp),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Box(
                            modifier = Modifier
                                .size(75.dp)
                                .background(colorState.value.copy(alpha = 0.5f))
                                .padding(horizontal = 16.dp)
                        )

                    }

                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                buttonColors.forEachIndexed { index, colorState ->
                    DraggableButton(
                        color = colorState.value,
                        position = buttonPositions[index].value,
                        onDragEnd = {

                                viewModel.updateButtonPosition(index, it)

                        }
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    viewModel.resetTotalButtonPosition()
                    navigationController.navigate(Routes.Home.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                shape = MaterialTheme.shapes.small
            ) {
                Text(text = "Volver", fontSize = 24.sp)
            }
        }
    }
}

@Composable
fun DraggableButton(
    color: Color,
    position: Offset,
    onDragEnd: (Offset) -> Unit,

) {
    var offsetX by remember { mutableStateOf(position.x) }
    var offsetY by remember { mutableStateOf(position.y) }

    val scope = rememberCoroutineScope()


    Box(
        modifier = Modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .size(75.dp)
            .background(color)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            },
        contentAlignment = Alignment.Center

        ) {
        Text(text = "Drag me", color = Color.White, fontWeight = FontWeight.Bold)
    }

    DisposableEffect(Unit) {
        onDispose {
            onDragEnd(Offset(offsetX, offsetY))
        }
    }
    LaunchedEffect(position) {
        offsetX = position.x
        offsetY = position.y
    }
}
