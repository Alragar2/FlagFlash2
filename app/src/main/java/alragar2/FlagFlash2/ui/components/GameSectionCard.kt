package alragar2.FlagFlash2.ui.components

import alragar2.FlagFlash2.R
import alragar2.FlagFlash2.ui.model.GameMode
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GameSectionCard(
    title: String,
    modes: List<GameMode>,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF0068F0), // Azul oscuro
                shape = RoundedCornerShape(24.dp) // Bordes redondeados
            )
            .padding(16.dp)
    ) {
        // Título de la sección (ej: "Un jugador")
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.padding(bottom = 16.dp, start = 8.dp)
        )
        BoxWithConstraints {
            val spacing = 16.dp
            val minSize = 150.dp
            val maxWidth = this.maxWidth

            // 1. Calculamos cuántas columnas caben
            val columns = maxOf(1, (maxWidth / minSize).toInt())

            // 2. Calculamos el ancho EXACTO que debe tener cada ítem.
            // Fórmula: (AnchoTotal - EspacioTotalOcupadoPorHuecos) / NumeroDeColumnas
            // Si hay 2 columnas, hay 1 hueco. Si hay 3 columnas, hay 2 huecos.
            val totalSpacing = spacing * (columns - 1)
            val itemWidth = (maxWidth - totalSpacing) / columns

            // Usamos FlowRow para simular un Grid dentro de la tarjeta
            // FlowRow permite que los elementos salten de línea automáticamente
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                // Ajusta el ancho segun dispositivo
                maxItemsInEachRow = columns
            ) {
                modes.forEach { gameMode ->
                    // Usamos Box con weight para distribuir el espacio equitativamente
                    Box(
                        modifier = Modifier
                            .width(itemWidth)
                    ) {
                        GameModeButton(
                            text = gameMode.title,
                            imagePainter = painterResource(id = gameMode.imageResId),
                            colorStart = gameMode.color1,
                            colorEnd = gameMode.color2,
                            onClick = {
                                if (gameMode.title == "Banderas") {
                                    navController.navigate("flagsGame")
                                } else {
                                    Log.d("GameMode", "Modo '${gameMode.title}' no implementado.")
                                }
                            }
                        )
                    }
                }

                val modulo = modes.size % columns
                if (modulo != 0) {
                    val itemsNeeded = columns - modulo
                    repeat(itemsNeeded) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun GameSectionCardPreview()
{
    val singlePlayerModes = listOf(
        GameMode("Banderas", R.drawable.icon_banderas, Color(0xFFACFFFB), Color(0xFF12C1C7)),
        GameMode("Banderas", R.drawable.icon_banderas, Color(0xFFACFFFB), Color(0xFF12C1C7)),
        GameMode("Banderas", R.drawable.icon_banderas, Color(0xFFACFFFB), Color(0xFF12C1C7)),
        GameMode("Banderas", R.drawable.icon_banderas, Color(0xFFACFFFB), Color(0xFF12C1C7)),
        GameMode("Banderas", R.drawable.icon_banderas, Color(0xFFACFFFB), Color(0xFF12C1C7)),)

    GameSectionCard(
        title = "Un jugador",
        modes = singlePlayerModes,
        navController = rememberNavController()
    )
}
