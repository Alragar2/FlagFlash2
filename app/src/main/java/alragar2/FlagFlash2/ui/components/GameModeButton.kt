package alragar2.FlagFlash2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import alragar2.FlagFlash2.R // Importante para acceder a los recursos
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.draw.shadow

@Composable
fun GameModeButton(
    text: String,
    imagePainter: Painter,
    colorStart: Color,
    colorEnd: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val gradientBrush = Brush.horizontalGradient(
        listOf(colorStart, colorEnd))
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(115.dp),
        shape = MaterialTheme.shapes.medium, // Bordes redondeados
        contentPadding = PaddingValues(0.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradientBrush),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
                    .padding(8.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = imagePainter,
                    contentDescription = text, // Descripción para accesibilidad
                    modifier = Modifier.size(60.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )

            }
        }
    }
}

@Preview(showBackground = true, widthDp = 180)
@Composable
fun GameModeButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        GameModeButton(
            text = "Banderas",
            imagePainter = painterResource(id = R.drawable.icon_flags), // Reemplaza con tu icono
            colorStart = Color(0xFFACFFFB),
            colorEnd = Color(0xFF12C1C7),
            onClick = {}
        )
        GameModeButton(
            text = "Capitales",
            imagePainter = painterResource(id = R.drawable.icon_capitales), // Reemplaza con tu icono
            colorStart = Color(0xFFFF9191),
            colorEnd = Color(0xFFC51E1E),
            onClick = {}
        )
    }
}
