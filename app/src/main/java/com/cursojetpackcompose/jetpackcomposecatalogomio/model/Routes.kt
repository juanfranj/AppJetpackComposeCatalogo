package com.cursojetpackcompose.jetpackcomposecatalogomio.model

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object Components : Routes("componente")
    object Instagram: Routes("instagram")
    object Layout: Routes("layout")
    object ComplexLayout: Routes("complexLayout")
    object Pantalla2: Routes("pantalla2")
    object Pantalla3: Routes("pantalla3")
    object Pantalla4: Routes("pantalla4/{age}"){
        fun createRoute(age: Int) = "pantalla4/$age"
    }
    object Pantalla5: Routes("pantalla5/{nombre}"){
        fun createRoute(nombre: String) = "pantalla5/$nombre"
    }

    object Pantalla6: Routes("pantalla6?name={name}") {
        fun createRoute(name: String) = "pantalla6?name=$name"
    }
    object BotonMultiseleccion: Routes("botonMultiseleccion")
    //Voy a pasar a la pantalla datos desde el viewModel
    object DetailBotonMultiseleccion: Routes("detailBotonMultiseleccion")
    object FlowScreen: Routes("flowScreen")
    object StateFlowScreen: Routes("stateFlowScreen")
    object Progress: Routes("progress")
    object Anuncios: Routes("anuncios")
    object Banner: Routes("banner")
    object Interstitial: Routes("interstitial")
    object Rewarded: Routes("rewarded")
    object FireBase: Routes("fireBase")
    object FireBaseAnalytics: Routes("fireBaseAnalytics")
    object MovimientoBoton: Routes("movimientoBoton")
    object MovimientoPrueba: Routes("movimientoPrueba")
    object PantallaPrueba: Routes("pantallaPrueba")
    object DialogoAppMultiplicar: Routes("diaoloAppMultiplicar")
    object ValorarApp: Routes("valorarApp")

}