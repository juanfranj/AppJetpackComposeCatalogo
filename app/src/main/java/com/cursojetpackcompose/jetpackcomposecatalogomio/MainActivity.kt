package com.cursojetpackcompose.jetpackcomposecatalogomio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.cursojetpackcompose.jetpackcomposecatalogomio.StateFlow.ui.StateFlowScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.StateFlow.ui.StateFlowViewModel
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
import com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui.FlowScreen
import com.cursojetpackcompose.jetpackcomposecatalogomio.flow.ui.FlowViewModel
import com.cursojetpackcompose.jetpackcomposecatalogomio.home.Home
import com.cursojetpackcompose.jetpackcomposecatalogomio.progressBar.ui.MyProgress
import com.cursojetpackcompose.jetpackcomposecatalogomio.progressBar.ui.ProgressBarViewmodel
import com.cursojetpackcompose.jetpackcomposecatalogomio.ui.theme.JetpackComposeCatalogoMioTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private val componentsViewModel: ComponentesViewModel by viewModels()
    private val detailButtonMultiSelectViewModel: DetailButtonMultiSelectViewModel by viewModels()
    private val flowViewModel: FlowViewModel by viewModels()
    private val stateFlowViewModel: StateFlowViewModel by viewModels()
    private val progressViewModel: ProgressBarViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                            DetailButtonMultiSelect(navigationController, detailButtonMultiSelectViewModel)
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
                        composable(route = Routes.FlowScreen.route) { FlowScreen(navigationController, flowViewModel)  }
                        //Pantalla StateFlow
                        composable(route = Routes.StateFlowScreen.route) { StateFlowScreen(navigationController, stateFlowViewModel)  }
                        //Pantalla ProgressBar
                        composable(route = Routes.Progress.route){ MyProgress(navigationController, progressViewModel) }
                    }
                }
            }
        }
    }
}




