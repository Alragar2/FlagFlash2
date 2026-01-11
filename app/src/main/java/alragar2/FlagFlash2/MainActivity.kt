package alragar2.FlagFlash2


import alragar2.FlagFlash2.ui.screens.FlagsGameScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import alragar2.FlagFlash2.ui.screens.GameModesScreen
import alragar2.FlagFlash2.ui.screens.HomeScreen
import alragar2.FlagFlash2.ui.theme.FlagFlash2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlagFlash2Theme {
                // Contenedor principal de la navegación
                AppNavigation()
            }
        }
    }
}

// Creamos un Composable para gestionar la navegación
@Composable
fun AppNavigation() {
    // 1. Crea el controlador de navegación
    val navController = rememberNavController()

    // 2. Define el NavHost con las rutas
    NavHost(navController = navController, startDestination = "home") {
        // Ruta para la pantalla principal
        composable("home") {
            HomeScreen(onNavigateToGameModes = {
                navController.navigate("gameModes")
            })
        }

        // Ruta para la pantalla de modos de juego
        composable("gameModes") {
            GameModesScreen(navController = navController)
        }
        composable("flagsGame") {
            FlagsGameScreen()
        }
    }
}
    