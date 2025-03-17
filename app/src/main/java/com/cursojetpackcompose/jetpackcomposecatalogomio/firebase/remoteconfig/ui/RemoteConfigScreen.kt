package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RemoteConfigScreen(
    navigationController: NavHostController,
    remoteConfigViewModel: RemoteConfigViewModel
) {

    LaunchedEffect(Unit) {
        remoteConfigViewModel.initApp()
    }
    //Esto lo pongo donde se inicia la App, por ejemplo en el splash screen
//    remoteConfigViewModel.initApp()
    val appInfo by remoteConfigViewModel.appInfoText.observeAsState()
    val showDialog by remoteConfigViewModel.showBlockDialog.collectAsState(null)

    Scaffold() { conttentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(conttentPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))
            AnimatedVisibility(
                visible = appInfo?.showText ?: false,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .background(Color.LightGray.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
                    // Padding interno para el Box
                ) {
                    Text(
                        text = appInfo?.title ?: "",
                        modifier = Modifier
                            .padding(16.dp),
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.Blue,
                        fontSize = 28.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { navigationController.navigate(Routes.FireBase.route) },
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Volver", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }

        }
//        BottomSlideDialog(
//            showDialog = showDialog ?: false,
//            onDismiss = { remoteConfigViewModel.closeDialog() }
//        )

    }
    BottomSheetDialog(
        showDialog = showDialog ?: false,
        onDismiss = { remoteConfigViewModel.closeDialog() }
    )
}

@Composable
fun BottomSlideDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Nueva actualización disponible")
            },
            text = {
                Text("Existe una actualización disponible. ¿Deseas actualizar ahora?")
            },
            confirmButton = {
                Button(
                    onClick = {
//                        onUpdateClick()
                        onDismiss()
                    },
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text("Actualizar")
                }
            },
            dismissButton = {
                Button(
                    onClick = onDismiss,
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray,
                        contentColor = Color.White
                    )
                ) {
                    Text("Cerrar")
                }

            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun BottomSheetDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = if (showDialog) ModalBottomSheetValue.Expanded else ModalBottomSheetValue.Hidden
    )

    LaunchedEffect(showDialog) {
        if (showDialog) {
            sheetState.show()
        } else {
            sheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Este es un Bottom Sheet",
                    fontSize = 20.sp,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onDismiss() },
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text("Cerrar")
                }
            }
        },

        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        scrimColor = Color.Transparent // Evita cerrar el BottomSheet al hacer clic fuera de él
    ) {
//        // Contenido principal de la pantalla
        Box(

        ) {
        }
    }
}





