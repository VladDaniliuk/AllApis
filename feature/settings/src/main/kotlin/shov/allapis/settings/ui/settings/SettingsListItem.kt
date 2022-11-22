package shov.allapis.settings.ui.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ColorLens
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import shov.allapis.datastore.THEME
import shov.allapis.settings.R
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsListItem(
    headlineString: String,
    modifier: Modifier = Modifier,
    supportingString: String? = null,
    leadingImageVector: ImageVector? = null,
    trailingContent: @Composable (() -> Unit)? = null
) {
    ListItem(
        modifier = modifier,
        headlineText = {
            Text(text = headlineString)
        },
        supportingText = supportingString?.let {
            { Text(text = supportingString) }
        },
        leadingContent = leadingImageVector?.let {
            {
                Icon(
                    imageVector = leadingImageVector,
                    contentDescription = leadingImageVector.name
                )
            }
        },
        trailingContent = trailingContent
    )
}

@Preview(showBackground = true)
@Composable
fun SettingsListItemPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        Column {
            SettingsListItem(
                headlineString = stringResource(R.string.dynamic_colors),
                supportingString = stringResource(R.string.enable_dynamic_or_use_default_colors),
                leadingImageVector = Icons.Rounded.ColorLens
            ) {
                Switch(
                    checked = true,
                    onCheckedChange = {}
                )
            }

            SettingsListItem(
                headlineString = stringResource(R.string.dark_theme),
                supportingString = stringResource(R.string.use_theme, THEME.DARK.name.lowercase()),
                leadingImageVector = Icons.Rounded.DarkMode
            )
        }
    }
}
