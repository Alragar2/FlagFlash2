package alragar2.FlagFlash2.data

import alragar2.FlagFlash2.R
import alragar2.FlagFlash2.ui.model.GameMode
import androidx.compose.ui.graphics.Color

object GameModesData {
    val singlePlayerModes = listOf(
        GameMode("Quiz", R.drawable.icon_flags, Color(0xFFACFFFB), Color(0xFF12C1C7)),
        GameMode("Emparejar", R.drawable.icon_flags, Color(0xFFFFF9BD), Color(0xFFDFCF21)),
        GameMode("Escritura", R.drawable.icon_flags, Color(0xFFDEADFF), Color(0xFFA825FF)),
        GameMode("Orden correcto", R.drawable.icon_flags, Color(0xFF93FB79), Color(0xFF3DB705)),
        GameMode("Mayor menor", R.drawable.icon_flags, Color(0xFFFFB37D), Color(0xFFE05D00)),

    )

    val multiPlayerModes = listOf(
        GameMode("1 vs 1", R.drawable.icon_flags, Color(0xFFFFF59D), Color(0xFFFBC02D)),
        GameMode("Torneo", R.drawable.icon_banderas, Color(0xFFA5D6A7), Color(0xFF388E3C))
    )

    val themes = listOf(
        GameMode("Banderas", R.drawable.icon_banderas, Color(0xFFACFFFB), Color(0xFF12C1C7)),
        GameMode("Capitales", R.drawable.icon_capitales, Color(0xFFFF9191), Color(0xFFC51E1E)),
        GameMode("Paises", R.drawable.icon_flags, Color(0xFFFFA3F6), Color(0xFFC223B7)),
        GameMode("Escudo", R.drawable.icon_flags, Color(0xFF93FB79), Color(0xFF3DB705)),
        GameMode("Siluetas", R.drawable.icon_flags, Color(0xFFFFB37D), Color(0xFFE05D00)),
        GameMode("Población", R.drawable.icon_flags, Color(0xFFACFFFB), Color(0xFF12C1C7)),
        GameMode("Area", R.drawable.icon_flags, Color(0xFFFF9191), Color(0xFFC51E1E)),
        GameMode("Idiomas", R.drawable.icon_flags, Color(0xFFFFA3F6), Color(0xFFC223B7)),
        GameMode("Comunidades", R.drawable.icon_flags, Color(0xFFD4AF37), Color(0xFFD4AF37)),
        )
}
