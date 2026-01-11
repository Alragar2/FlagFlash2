package alragar2.FlagFlash2.data

import alragar2.FlagFlash2.R

// Describe una única pregunta del juego de banderas
data class FlagQuestion(
    val imageResId: Int, // El ID de la imagen de la bandera
    val options: List<String>, // Lista de 4 nombres de países
    val correctAnswer: String // El nombre correcto
)

// Una lista de ejemplo con preguntas. ¡Asegúrate de tener estas imágenes en res/drawable!
// Para este ejemplo, he usado los iconos que ya teníamos. DEBERÍAS CAMBIARLOS por banderas reales.
val flagsQuestions = listOf(
    FlagQuestion(
        imageResId = R.drawable.icon_flags, // TODO: Cambiar por una bandera real (ej. R.drawable.flag_spain)
        options = listOf("España", "Francia", "Italia", "Portugal"),
        correctAnswer = "España"
    ),
    FlagQuestion(
        imageResId = R.drawable.icon_capitales, // TODO: Cambiar por R.drawable.flag_germany
        options = listOf("Alemania", "Bélgica", "Polonia", "Austria"),
        correctAnswer = "Alemania"
    ),
    FlagQuestion(
        imageResId = R.drawable.icon_flags, // TODO: Cambiar por R.drawable.flag_japan
        options = listOf("China", "Corea del Sur", "Japón", "Tailandia"),
        correctAnswer = "Japón"
    )
    // Añade más preguntas aquí...
)
