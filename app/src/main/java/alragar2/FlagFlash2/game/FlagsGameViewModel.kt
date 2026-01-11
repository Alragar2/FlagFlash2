package alragar2.FlagFlash2.game

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import alragar2.FlagFlash2.data.FlagQuestion
import alragar2.FlagFlash2.data.flagsQuestions
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class FlagsGameViewModel : ViewModel() {

    // Estado del juego que la UI observará
    private val _lives = mutableStateOf(3)
    val lives: State<Int> = _lives

    private val _currentQuestionIndex = mutableStateOf(0)
    val currentQuestionIndex: State<Int> = _currentQuestionIndex

    val totalQuestions = flagsQuestions.size

    // La pregunta actual que se muestra en la UI
    fun getCurrentQuestion(): FlagQuestion? {
        return flagsQuestions.getOrNull(_currentQuestionIndex.value)
    }

    // Lógica para manejar la respuesta del usuario
    fun checkAnswer(selectedAnswer: String) {
        val currentQuestion = getCurrentQuestion()
        if (currentQuestion != null) {
            if (selectedAnswer == currentQuestion.correctAnswer) {
                // Respuesta correcta: pasar a la siguiente pregunta
                goToNextQuestion()
            } else {
                // Respuesta incorrecta: perder una vida
                _lives.value--
                // Aquí podrías añadir una lógica para cuando se pierden todas las vidas
            }
        }
    }

    private fun goToNextQuestion() {
        if (_currentQuestionIndex.value < totalQuestions - 1) {
            _currentQuestionIndex.value++
        } else {
            // Fin del juego (has completado todas las preguntas)
            // Aquí podrías navegar a una pantalla de resultados
        }
    }
}