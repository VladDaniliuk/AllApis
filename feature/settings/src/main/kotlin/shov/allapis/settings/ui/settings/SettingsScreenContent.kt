package shov.allapis.settings.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ColorLens
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import shov.allapis.datastore.THEME
import shov.allapis.settings.R
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@Composable
fun SettingsScreenContent(
    popBackStack: () -> Unit,
    isDynamicColor: Boolean,
    setDynamicColor: (Boolean) -> Unit,
    themeVariant: String,
    onThemeOpen: () -> Unit,
    modifier: Modifier = Modifier
) {
    SettingsScaffold(
        modifier = modifier,
        popBackStack = popBackStack
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            SettingsListItem(
                modifier = Modifier.toggleable(
                    value = isDynamicColor,
                    role = Role.Switch,
                    onValueChange = setDynamicColor
                ),
                headlineString = stringResource(R.string.dynamic_colors),
                supportingString = stringResource(R.string.enable_dynamic_or_use_default_colors),
                leadingImageVector = Icons.Rounded.ColorLens
            ) {
                Switch(
                    checked = isDynamicColor,
                    onCheckedChange = setDynamicColor
                )
            }

            SettingsListItem(
                modifier = Modifier.clickable(onClick = onThemeOpen),
                headlineString = stringResource(R.string.dark_theme),
                supportingString = stringResource(R.string.use_theme, themeVariant),
                leadingImageVector = Icons.Rounded.DarkMode
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenContentPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        SettingsScreenContent(
            popBackStack = {},
            isDynamicColor = true,
            setDynamicColor = {},
            onThemeOpen = {},
            themeVariant = THEME.SYSTEM.name.lowercase()
        )
    }
}
