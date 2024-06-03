package com.cursojetpackcompose.jetpackcomposecatalogomio.progressBar.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable

fun MyProgress(navigationController: NavHostController, progressViewModel: ProgressBarViewmodel) {

    var showLoading by rememberSaveable { mutableStateOf(false) }
    val progressStatus by progressViewModel.progressStatus.collectAsState(initial = 0f)

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showLoading) {

            LinearProgressIndicator(
                progress = progressStatus,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                color = Color.Green,
                trackColor = Color.Gray

            )
            CircularProgressIndicator(
                progress = progressStatus,
                modifier = Modifier
                    .padding(32.dp),
                color = Color.Red,
                strokeWidth = 4.dp

            )
        }

        Button(
            onClick = {
                progressViewModel.startProgress()
                showLoading = !showLoading },
            modifier = Modifier
                .width(300.dp)
                .padding(32.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Cargar Perfil", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
        Button(
            onClick = { navigationController.navigate("home") },
            modifier = Modifier
                .width(300.dp)
                .padding(32.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "Volver", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }

        MyProgressAdvance(progressViewModel)
    }

}

@Composable
fun MyProgressAdvance(progressViewModel: ProgressBarViewmodel) {

//    var progressStatus by rememberSaveable { mutableStateOf(0.5f) }
    val progress by progressViewModel.progress.collectAsState(initial = 0.0f)
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier
                .padding(32.dp),
            color = Color.Red,
        )

        Row(horizontalArrangement = Arrangement.SpaceBetween) {

            Button(
                onClick = { progressViewModel.incrementCircularProgress() },
                modifier = Modifier
                    .padding(8.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Incrementar", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }

            Button(
                onClick = { progressViewModel.decrementCircularProgress() },
                modifier = Modifier
                    .padding(8.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Decrementar", fontSize = MaterialTheme.typography.titleLarge.fontSize)
            }
        }
    }
}