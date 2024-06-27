package com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val texto by remoteConfigViewModel.texto.observeAsState()
    val showText by remoteConfigViewModel.showText.observeAsState(false)
    val appInfo by remoteConfigViewModel.appInfoText.observeAsState()

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

    }
}