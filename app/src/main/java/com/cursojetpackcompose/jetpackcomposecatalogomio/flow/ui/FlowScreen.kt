package com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.layout.ui.GitHubIcon


@Composable
fun FlowScreen(
    navigationController: NavHostController,
    flowViewModel: FlowViewModel,
) {
    val githubRepoUrl =
        "https://github.com/juanfranj/AppJetpackComposeCatalogo/blob/main/app/src/main/java/com/cursojetpackcompose/jetpackcomposecatalogomio/layout/ui/EjercicioUno.kt"

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow Back",
                modifier = Modifier
                    .padding(16.dp)
                    .size(30.dp)
                    .align(Alignment.TopEnd)
                    .clickable { navigationController.popBackStack() })
//            OpenGitHubRepoButton()
            GitHubIcon(githubRepoUrl = githubRepoUrl) }

        CounterScreen(flowViewModel = flowViewModel)
        Spacer(modifier = Modifier.height(200.dp))

        Button(onClick = { flowViewModel.startCounter() }, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "Comenzar Contador", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
        Button(onClick = { flowViewModel.resetCounter() }, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "Resetear Contador", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
        Button(onClick = { flowViewModel.stopCounter() }, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "Detener Contador", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
        Button(onClick = { navigationController.popBackStack()}, modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "Volver", fontSize = MaterialTheme.typography.titleLarge.fontSize)
        }
    }

}


@Composable
fun CounterScreen(flowViewModel: FlowViewModel) {
    
    val counter by flowViewModel.counterState.collectAsState()

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Contador: $counter",
            fontSize = 34.sp, fontWeight = FontWeight.Bold
        )
    }
}
