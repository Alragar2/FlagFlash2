package alragar2.FlagFlash2.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyButton(
    text: String,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun MyButtonPreview() {
    MyButton(text = "Pulsa", onClick = { /* Handle button click */ })
}