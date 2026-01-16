package alragar2.FlagFlash2.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GameModeCard(title: String, onClick: () -> Unit) {
    // Esto es solo un ejemplo, reemplázalo con tu propio diseño de tarjeta
    Card(
        modifier = Modifier.width(200.dp), // Ancho fijo para que quepan varias en la pantalla
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}