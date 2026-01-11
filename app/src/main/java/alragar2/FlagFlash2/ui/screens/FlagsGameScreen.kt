package alragar2.FlagFlash2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import alragar2.FlagFlash2.game.FlagsGameViewModel

@Composable
fun FlagsGameScreen(gameViewModel: FlagsGameViewModel = viewModel()) {
    val lives by gameViewModel.lives
    val currentQuestionIndex by gameViewModel.currentQuestionIndex
    val totalQuestions = gameViewModel.totalQuestions
    val currentQuestion = gameViewModel.getCurrentQuestion()

    if (currentQuestion == null || lives <= 0) {
        // Pantalla de fin de juego (simplificada)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Fin del Juego", fontSize = 32.sp)
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // 1. Barra de estado (Progreso y Vidas)
        GameStatus(
            currentQuestion = currentQuestionIndex + 1,
            totalQuestions = totalQuestions,
            lives = lives
        )

        // 3. Imagen de la bandera
        Image(
            painter = painterResource(id = currentQuestion.imageResId),
            contentDescription = "Bandera a adivinar",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(vertical = 16.dp)
        )

        // 4. Opciones de respuesta
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            currentQuestion.options.shuffled().forEach { option ->
                Button(
                    onClick = { gameViewModel.checkAnswer(option) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = option, fontSize = 18.sp, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun GameStatus(currentQuestion: Int, totalQuestions: Int, lives: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Contador de preguntas
        Text(
            text = "Pregunta: $currentQuestion / $totalQuestions",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        // Contador de vidas
        Row(verticalAlignment = Alignment.CenterVertically) {
            repeat(lives) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Vida",
                    tint = Color.Red,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FlagsGameScreenPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        GameStatus(currentQuestion = 1, totalQuestions = 10, lives = 3)

        Image(
            painter = painterResource(id = alragar2.FlagFlash2.R.drawable.icon_flags),
            contentDescription = "Bandera",
            modifier = Modifier.height(200.dp)
        )

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Opción 1") }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Opción 2") }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Opción 3") }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Opción 4") }
        }
    }
}
