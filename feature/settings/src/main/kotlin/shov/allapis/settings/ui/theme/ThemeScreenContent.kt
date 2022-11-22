package shov.allapis.settings.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import shov.allapis.datastore.THEME
import shov.allapis.settings.R
import shov.allapis.ui.text.RadioText
import shov.allapis.ui.text.StyledText
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@Composable
fun ThemeScreenContent(
    theme: THEME,
    setTheme: (THEME) -> Unit,
    onOkClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            StyledText(
                text = stringResource(R.string.dark_mode),
                textStyle = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
            )

            StyledText(
                modifier = Modifier.padding(vertical = 16.dp),
                text = stringResource(R.string.choose_dark_mode_preferences),
                textStyle = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Divider()

            RadioText(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.system_default),
                selected = theme == THEME.SYSTEM,
                onClick = { setTheme(THEME.SYSTEM) }
            )

            RadioText(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.light),
                selected = theme == THEME.LIGHT,
                onClick = { setTheme(THEME.LIGHT) }
            )

            RadioText(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.dark),
                selected = theme == THEME.DARK,
                onClick = { setTheme(THEME.DARK) }
            )

            Divider()

            TextButton(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.End),
                onClick = onOkClick
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = stringResource(R.string.ok)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ThemeScreenContentPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        ThemeScreenContent(theme = THEME.DARK, setTheme = {}, onOkClick = {})
    }
}
