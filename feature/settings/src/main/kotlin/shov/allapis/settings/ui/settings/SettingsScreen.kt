package shov.allapis.settings.ui.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import shov.allapis.datastore.THEME
import shov.allapis.ui.navigation.Screens
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@Composable
fun SettingsScreen(navController: NavController, modifier: Modifier = Modifier) {
    val settingsViewModel = hiltViewModel<SettingsViewModel>()
    val isDynamicColor by settingsViewModel.isDynamicColor.collectAsState()
    val themeVariant by settingsViewModel.theme.collectAsState()

    SettingsScreenContent(
        popBackStack = navController::popBackStack,
        isDynamicColor = isDynamicColor,
        setDynamicColor = settingsViewModel::setDynamicColor,
        themeVariant = themeVariant,
        onThemeOpen = {
            navController.navigate(Screens.Theme.name)
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        SettingsScreenContent(
            popBackStack = {},
            isDynamicColor = true,
            setDynamicColor = {},
            themeVariant = THEME.SYSTEM.name.lowercase(),
            onThemeOpen = {}
        )
    }
}
