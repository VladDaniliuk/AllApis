package shov.allapis.ui.utils

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import shov.allapis.ui.theme.AllApisTheme

class CustomPreviewParameterProvider : PreviewParameterProvider<Pair<Boolean, Boolean>> {
    override val values = sequenceOf(false to false, false to true, true to false, true to true)
}

@Composable
fun CustomPreview(
    isDark: Boolean,
    isDynamic: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    AllApisTheme(modifier = modifier, darkTheme = isDark, dynamicColor = isDynamic) {
        Surface(color = MaterialTheme.colorScheme.background) {
            CustomScaffold { paddingValues ->
                content(paddingValues)
            }
        }
    }
}
