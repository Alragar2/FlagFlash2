package alragar2.FlagFlash2.ui.screens

import alragar2.FlagFlash2.data.GameModesData
import alragar2.FlagFlash2.ui.components.GameModeCard
import alragar2.FlagFlash2.ui.components.GameSectionCard
import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState


@Composable
fun GameModesScreen(navController: NavController) {
    // Datos
    val singlePlayerModes = GameModesData.singlePlayerModes
    val multiPlayerModes = GameModesData.multiPlayerModes
    val themes = GameModesData.themes


    // UI Principal
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // 1. Título principal
        item {
            Text(
                text = "Elige un modo de juego",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.width(16.dp))

                // Iteramos sobre los modos y creamos una tarjeta para cada uno
                singlePlayerModes.forEach { gameMode ->
                    GameModeCard( // Un Composable más simple para una tarjeta individual
                        title = gameMode.title,
                        // Aquí iría una acción de click, por ejemplo
                        onClick = { Log.d("GameMode", "Clicked on ${gameMode.title}") }
                    )
                }

                // Espaciador final para que la última tarjeta no quede pegada al borde derecho
                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        // Espaciador
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        // 2. Tarjeta Un Jugador
        item {
            GameSectionCard(
                title = "Tematicas",
                modes = GameModesData.themes,
                navController = navController
            )
        }

        // Espaciador
        item {
            Spacer(modifier = Modifier.height(24.dp))
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

