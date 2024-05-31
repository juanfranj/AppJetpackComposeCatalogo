package com.cursojetpackcompose.jetpackcomposecatalogomio.layout.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.R

@Composable
fun EjercicioUno(navigationController: NavHostController) {
    val githubRepoUrl =
        "https://github.com/juanfranj/AppJetpackComposeCatalogo/blob/main/app/src/main/java/com/cursojetpackcompose/jetpackcomposecatalogomio/layout/ui/EjercicioUno.kt"

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
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
            GitHubIcon(githubRepoUrl = githubRepoUrl)


        }
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }

        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun OpenGitHubRepoButton() {
    val context = LocalContext.current
    val githubRepoUrl = "https://github.com/tu-usuario/tu-repositorio"

    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubRepoUrl))
                context.startActivity(intent)
            },
            containerColor = Color.White,
            contentColor = Color.Black,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_github), // Usa el ID de tu ícono SVG convertido
                contentDescription = "Open GitHub Repo"

            )

        }
    }
}

@Composable
fun GitHubIcon(githubRepoUrl: String) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_github), // Usa el ID de tu ícono SVG convertido
            contentDescription = "Open GitHub Repo",
            tint = Color.Unspecified, // Mantén el color original del ícono
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(30.dp)
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubRepoUrl))
                    context.startActivity(intent)
                }
        )
    }
}


//@Preview(showBackground = true, name = "EjercicioUno")
//@Composable
//fun GreetingPreviewEjercicioUno() {
//    JetpackComposeCatalogoMioTheme {
//        EjercicioUno()
//    }
//}