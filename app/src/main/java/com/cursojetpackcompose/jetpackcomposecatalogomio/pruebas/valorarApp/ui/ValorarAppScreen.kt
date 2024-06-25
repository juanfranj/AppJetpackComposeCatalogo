package com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.valorarApp.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cursojetpackcompose.jetpackcomposecatalogomio.R
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.BotonVerde
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.Dorado
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.TituloCard

@Composable
fun ValorarAppScreen(
    navigationController: NavHostController,
    valorarAppViewModel: ValorarAppViewModel
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(TituloCard)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextoValorarAppCabecera(Alignment.CenterHorizontally)
            BodyValorarApp(context)
            Spacer(modifier = Modifier.height(16.dp))
            TextoMotivacion()
            TextoAuxiliar()
            Fotter(navigationController, context)

        }
    }
}

@Composable
fun Fotter(navigationController: NavHostController, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(
            onClick = {
                // Acción para redirigir a la valoración de la app
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data =
                    Uri.parse("https://play.google.com/store/apps/details?id=com.estudiartablas.tablasmultiplicar") // Reemplaza con tu app ID
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = BotonVerde,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.Boton_valorar),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
        }
        Button(
            onClick = { navigationController.navigate(Routes.PantallaPrueba.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.Boton_rechazar),
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun TextoAuxiliar() {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp),
        text = "Tu opinión ayudará a otros usuarios a mejorar su experiencia con el juego.",
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    )
}

@Composable
fun TextoMotivacion() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
            .border(2.dp, Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.Valorar_motivacion),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.EmojiEvents, // Icono de corona
                contentDescription = "Corona",
                tint = Dorado, // Color dorado
                modifier = Modifier.size(42.dp)
            )
        }

    }
}

@Composable
fun BodyValorarApp(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
//            .background(Color.LightGray.copy(alpha = 0.7f), RoundedCornerShape(8.dp))
//            .border(2.dp, Color.White, RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

//        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color.LightGray.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                    .border(2.dp, Dorado, RoundedCornerShape(8.dp))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
            ) {
                Row() {
                    repeat(5) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.star_on),
                            contentDescription = "Estrella",
                            tint = Dorado, // Color dorado
//                        modifier = Modifier.size(16.dp) // Tamaño de las estrellas
                        )
                    }
                }

                Text(
                    text = stringResource(id = R.string.Valorar_positivo),
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White

                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color.LightGray.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                    .border(2.dp, Dorado, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .clickable {
                        enviarCorreo(
                            context,
                            "juanfranj80@gmail.com",
                            "Opinion about the app",
                            "Write your opinion and how we can improve the application. We will try to implement improvements as quickly as possible. "
                        )
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
            ) {
                Row() {
                    repeat(5) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.star_on),
                            contentDescription = "Estrella",
                            tint = if (it < 2) Color(0xFFFFD700) else Color.Gray,
                        )
                    }
                }

                Text(
                    text = stringResource(id = R.string.Valorar_negativo),
                    modifier = Modifier.padding(vertical = 8.dp),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White

                )
            }
        }
    }
}

@Composable
fun TextoValorarAppCabecera(center: Alignment.Horizontal) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .background(Color.LightGray.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
            .border(2.dp, Color.White, RoundedCornerShape(8.dp)),
        horizontalAlignment = center,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.Valorar_titulo),
            modifier = Modifier.padding(16.dp),
            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            lineHeight = 32.sp

        )
    }
}

fun enviarCorreo(context: Context, destinatario: String, asunto: String, mensaje: String) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data =
            Uri.parse("mailto:") // Solo las aplicaciones de correo electrónico deberían manejar esto
        putExtra(Intent.EXTRA_EMAIL, arrayOf(destinatario))
        putExtra(Intent.EXTRA_SUBJECT, asunto)
        putExtra(Intent.EXTRA_TEXT, mensaje)
    }
    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        // Gmail no está instalado, intenta con otro cliente de correo
        val fallbackIntent = Intent(Intent.ACTION_SEND).apply {
            type = "message/rfc822"
            putExtra(Intent.EXTRA_EMAIL, arrayOf(destinatario))
            putExtra(Intent.EXTRA_SUBJECT, asunto)
            putExtra(Intent.EXTRA_TEXT, mensaje)
        }
        context.startActivity(
            Intent.createChooser(
                fallbackIntent,
                "Elige una aplicación de correo"
            )
        )
    }
}
