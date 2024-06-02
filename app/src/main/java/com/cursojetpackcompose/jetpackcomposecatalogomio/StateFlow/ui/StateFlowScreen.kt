package com.cursojetpackcompose.jetpackcomposecatalogomio.StateFlow.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui.FlowScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui.FlowViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes


@Composable
fun StateFlowScreen(navigationController: NavHostController,
                    viewModel: StateFlowViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading -> {
            LoadingScreen()
        }
        is UiState.Success -> {
            SuccessScreen((uiState as UiState.Success).data)
            navigationController.navigate(Routes.FlowScreen.route)
        }
        is UiState.Error -> {
            ErrorScreen((uiState as UiState.Error).message)
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(progress = .7f)
    }
}

@Composable
fun SuccessScreen(data: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = data, style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun ErrorScreen(message: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = message, style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.error)
    }
}
