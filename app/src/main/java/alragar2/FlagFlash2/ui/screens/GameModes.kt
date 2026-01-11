package alragar2.FlagFlash2.ui.screens

import alragar2.FlagFlash2.data.GameModesData
import alragar2.FlagFlash2.R
import alragar2.FlagFlash2.ui.components.GameSectionCard
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import alragar2.FlagFlash2.ui.model.GameMode
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.*


@Composable
fun GameModesScreen(navController: NavController) {
    // Datos
    val singlePlayerModes = GameModesData.singlePlayerModes
    val multiPlayerModes = GameModesData.multiPlayerModes

    // UI Principal
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 16.dp) // Ajuste de márgenes
    ) {

        // 1. Título principal
        item {
            Text(
                text = "Elige un modo de juego",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }

        // 2. Tarjeta Un Jugador
        item {
            GameSectionCard(
                title = "Un Jugador",
                modes = singlePlayerModes,
                navController = navController
            )
        }

        // Espaciador
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        // 3. Tarjeta Multijugador
        item {
            GameSectionCard(
                title = "Multijugador",
                modes = multiPlayerModes,
                navController = navController
            )
        }

        // Espaciador final para que no se corte abajo
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showBackground = true, name = "Redmi Note 9 Pro", widthDp = 400 , heightDp = 873)
@Composable
fun PreviewRedmiNote9Pro() {
    // Tu Composable aquí
    GameModesScreen(navController = rememberNavController())
}

@Preview(showBackground = true, name = "Teléfono Grande (2 Columnas)", widthDp = 411, heightDp = 800)
@Composable
fun GameModesScreenLargePhonePreview() {
    GameModesScreen(navController = rememberNavController())
}

// Preview para un teléfono más pequeño donde solo cabrá una columna.
@Preview(showBackground = true, name = "Teléfono Pequeño (1 Columna)", widthDp = 360, heightDp = 740)
@Composable
fun GameModesScreenSmallPhonePreview() {
    GameModesScreen(navController = rememberNavController())
}

// Preview para una tablet donde cabrán más de 2 columnas.
@Preview(showBackground = true, name = "Tablet (Múltiples Columnas)", widthDp = 800, heightDp = 1280)
@Composable
fun GameModesScreenTabletPreview() {
    GameModesScreen(navController = rememberNavController())
}

