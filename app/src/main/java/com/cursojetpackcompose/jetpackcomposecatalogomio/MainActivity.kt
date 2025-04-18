package com.cursojetpackcompose.jetpackcomposecatalogomio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import androidx.annotation.RequiresApi
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.BannerAd.ui.MyBannerScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.InterstitialAd.ui.MyInterstitialAd
import com.cursojetpackcompose.jetpackcomposecatalogomio.StateFlow.ui.StateFlowScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.StateFlow.ui.StateFlowViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.InterstitialAd.ui.InterstitialViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.RewardedAd.ui.MyRewardedAd
import com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.RewardedAd.ui.RewardedViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.ui.AnunciosViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.anuncios.ui.MyAnuncios
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.DetailButtonMultiSelect
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.DetailButtonMultiSelectViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.componentes.MultiSelectableButton
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.ui.ComponentesViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.instagram.login.ui.LoginScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.instagram.login.ui.LoginViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.layout.ui.EjercicioUno
import com.cursojetpackcompose.jetpackcomposecatalogomio.layout.ui.HomeLayout
import com.cursojetpackcompose.jetpackcomposecatalogomio.model.Routes
import com.cursojetpackcompose.jetpackcomposecatalogomio.navigation.Screen2
import com.cursojetpackcompose.jetpackcomposecatalogomio.navigation.Screen3
import com.cursojetpackcompose.jetpackcomposecatalogomio.navigation.Screen4
import com.cursojetpackcompose.jetpackcomposecatalogomio.navigation.Screen5
import com.cursojetpackcompose.jetpackcomposecatalogomio.navigation.Screen6
import com.cursojetpackcompose.jetpackcomposecatalogomio.components.ui.Components
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.analytics.ui.FireBaseAnalyticsScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.analytics.ui.FireBaseAnalyticsViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.ui.RemoteConfigScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.remoteconfig.ui.RemoteConfigViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.ui.FireBaseScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.firebase.ui.FireBaseViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui.FlowScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui.FlowViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.home.Home
import com.cursojetpackcompose.jetpackcomposecatalogomio.movimientoBoton.DragDropScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.movimientoBoton.DragDropViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.movimientoPrueba.ui.MovimientoPrueba
import com.cursojetpackcompose.jetpackcomposecatalogomio.movimientoPrueba.ui.MovimientoPruebaViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.progressBar.ui.MyProgress
import com.cursojetpackcompose.jetpackcomposecatalogomio.progressBar.ui.ProgressBarViewmodel
import com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.dialogoTablasMultiplicar.ui.DialogoTablasScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.dialogoTablasMultiplicar.ui.DialogoTablasViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.pantallaPrincipal.ui.PantallaPrincipalScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.pantallaPrincipal.ui.PantallaPrincipalViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.ui.PantallasPruebasScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.valorarApp.ui.ValorarAppScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.pruebas.valorarApp.ui.ValorarAppViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.JetpackComposeCatalogoMioTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.core.graphics.toColorInt

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val componentsViewModel: ComponentesViewModel by viewModels()
    private val detailButtonMultiSelectViewModel: DetailButtonMultiSelectViewModel by viewModels()
    private val flowViewModel: FlowViewModel by viewModels()
    private val stateFlowViewModel: StateFlowViewModel by viewModels()
    private val progressViewModel: ProgressBarViewmodel by viewModels()
    private val anunciosViewModel: AnunciosViewModel by viewModels()
    private val InterstitialViewModel: InterstitialViewModel by viewModels()
    private val RewardedViewModel: RewardedViewModel by viewModels()
    private val firebaseViewModel: FireBaseViewModel by viewModels()
    private val firebaseAnalyticsViewModel: FireBaseAnalyticsViewModel by viewModels()
    private val dragDropViewModel: DragDropViewModel by viewModels()
    private val movimientoPruebaViewModel: MovimientoPruebaViewModel by viewModels()
    private val dialogoTablasViewModel: DialogoTablasViewModel by viewModels()
    private val valorarAppViewModel: ValorarAppViewModel by viewModels()
    private val remoteConfigViewModel: RemoteConfigViewModel by viewModels()
    private val pantallaPrincipalViewModel: PantallaPrincipalViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Permite que la UI respete los insets del sistema (status bar, nav bar)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        // Colores de la status bar (superior) y navigation bar (inferior del sistema)
        window.statusBarColor = "#FFFBF4".toColorInt()
        window.navigationBarColor = "#FFFBF4".toColorInt()



        setContent {
//            flowViewModel.example()
            JetpackComposeCatalogoMioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Home()
                    val navigationController = rememberNavController()

                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Home.route
                    ) {
                        //composable(route = Routes.Pantalla1.route) { Screen1(navigationController) }
                        composable(route = Routes.Pantalla2.route) { Screen2(navigationController) }
                        composable(route = Routes.Pantalla3.route) { Screen3(navigationController) }
                        composable(route = Routes.Home.route) { Home(navigationController) }
                        //pantalla bonton multiseleccion
                        composable(route = Routes.BotonMultiseleccion.route) {
                            MultiSelectableButton(
                                navigationController = navigationController,
                                detailButtonMultiSelectViewModel = detailButtonMultiSelectViewModel
                            )
                        }
                        //Pantalla Detalles del boton multiseleccion pasandole los datos por viewModel
                        composable(route = Routes.DetailBotonMultiseleccion.route) {
                            DetailButtonMultiSelect(
                                navigationController,
                                detailButtonMultiSelectViewModel
                            )
                        }
                        composable(route = Routes.Instagram.route) {
                            LoginScreen(
                                navigationController,
                                loginViewModel = loginViewModel
                            )
                        }
                        composable(route = Routes.Layout.route) { HomeLayout(navigationController = navigationController) }
                        composable(route = Routes.ComplexLayout.route) {
                            EjercicioUno(navigationController = navigationController)
                        }
                        composable(route = Routes.Components.route) {
                            Components(
                                navigationController,
                                componentesViewModel = componentsViewModel
                            )
                        }
                        composable(
                            route = Routes.Pantalla4.route,
                            arguments = listOf(navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            Screen4(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                        composable(
                            route = Routes.Pantalla5.route,
                            arguments = listOf(navArgument("nombre") { type = NavType.StringType })
                        ) { backStackEntry ->
                            Screen5(
                                navigationController = navigationController,
                                name = backStackEntry.arguments?.getString("nombre").orEmpty()
                            )

                        }
                        composable(
                            route = Routes.Pantalla6.route,
                            arguments = listOf(navArgument("name", { defaultValue = "Ninguna" }))
                        ) { backStackEntry ->
                            Screen6(
                                navigationController = navigationController,
                                name = backStackEntry.arguments?.getString("name").orEmpty()
                            )
                        }
                        //Pantalla Flow
                        composable(route = Routes.FlowScreen.route) {
                            FlowScreen(
                                navigationController,
                                flowViewModel
                            )
                        }
                        //Pantalla StateFlow
                        composable(route = Routes.StateFlowScreen.route) {
                            StateFlowScreen(
                                navigationController,
                                stateFlowViewModel
                            )
                        }
                        //Pantalla ProgressBar
                        composable(route = Routes.Progress.route) {
                            MyProgress(
                                navigationController,
                                progressViewModel
                            )
                        }
                        //Pantalla Anuncios
                        composable(route = Routes.Anuncios.route) {
                            MyAnuncios(
                                navigationController,
                                anunciosViewModel
                            )
                        }
                        //Pantalla Banner
                        composable(route = Routes.Banner.route) {
                            MyBannerScreen(navigationController)
                        }
                        //Pantalla Interstitial
                        composable(route = Routes.Interstitial.route) {
                            MyInterstitialAd(
                                this@MainActivity,
                                navigationController,
                                InterstitialViewModel
                            )

                        }
                        //Pantalla RewardedAD
                        composable(route = Routes.Rewarded.route) {
                            MyRewardedAd(
                                activity = this@MainActivity,
                                navigationController = navigationController,
                                RewardedViewModel
                            )
                        }
                        //Pantalla FireBase
                        composable(route = Routes.FireBase.route) {
                            FireBaseScreen(navigationController, firebaseViewModel)
                        }
                        //Pantalla FireBaseAnalytics
                        composable(route = Routes.FireBaseAnalytics.route) {
                            FireBaseAnalyticsScreen(
                                navigationController,
                                firebaseAnalyticsViewModel
                            )
                        }
                        //Pantalla movimiento Boton
                        composable(route = Routes.MovimientoBoton.route) {
                            DragDropScreen(
                                dragDropViewModel,
                                navigationController,
                            )
                        }
                        //Pantalla movimiento de Prueba
                        composable(route = Routes.MovimientoPrueba.route) {

                            MovimientoPrueba(navigationController, movimientoPruebaViewModel)
                        }
                        //Pantalla Pruebas
                        composable(route = Routes.PantallaPrueba.route) {
                            PantallasPruebasScreen(navigationController = navigationController)
                        }
                        //Pantalla DiaologoAppMultiplicar
                        composable(route = Routes.DialogoAppMultiplicar.route) {
                            DialogoTablasScreen(navigationController, dialogoTablasViewModel)
                        }
                        //Pantalla ValorarApp
                        composable(route = Routes.ValorarApp.route) {
                            ValorarAppScreen(navigationController, valorarAppViewModel)
                        }
                        //Pantalla RemoteConfig
                        composable(route = Routes.RemoteConfig.route) {
                            RemoteConfigScreen(navigationController, remoteConfigViewModel)
                        }
                        //Pantalla Principal
                        composable(route = Routes.PantallaPrincipal.route) {
                            PantallaPrincipalScreen(navigationController, pantallaPrincipalViewModel)
                        }

                    }
                }
            }
        }
    }

}



