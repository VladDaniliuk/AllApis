package shov.allapis.ui.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@Composable
fun RadioText(text: String, selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Row(modifier = modifier.clickable(onClick = onClick)) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )

        Text(modifier = Modifier.align(Alignment.CenterVertically), text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun RadioTextPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        RadioText(text = "Radio text", selected = true, onClick = {})
    }
}
