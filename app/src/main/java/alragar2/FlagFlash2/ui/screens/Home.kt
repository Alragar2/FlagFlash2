package alragar2.FlagFlash2.ui.screens

// ... (otros imports)
import androidx.compose.runtime.Composable
import alragar2.FlagFlash2.ui.components.MyButton
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(onNavigateToGameModes: () -> Unit) { // 1. Recibe la acción de navegar
    Box(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()) {
        Column (modifier = Modifier.padding(16.dp)){
            Text(
                text = "Bienvenido a FlagFlash2!",
                modifier = Modifier.padding(16.dp)
            )
            // 2. Usa la acción en el onClick del botón
            MyButton(text = "Pulsa", onClick = onNavigateToGameModes)
        }
    }
}

// No necesitas más la función pulsa() aquí

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // Para el preview, pasamos una acción vacía
    HomeScreen(onNavigateToGameModes = {})
}
    