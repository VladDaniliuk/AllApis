package shov.allapis.settings.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import shov.allapis.datastore.THEME
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@Composable
fun ThemeScreen(navController: NavController, modifier: Modifier = Modifier) {
    val themeViewModel = hiltViewModel<ThemeViewModel>()
    val theme by themeViewModel.theme.collectAsState()

    ThemeScreenContent(
        theme = theme,
        setTheme = themeViewModel::setTheme,
        onOkClick = navController::popBackStack,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ThemeScreenPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        ThemeScreenContent(theme = THEME.DARK, setTheme = {}, onOkClick = {})
    }
}
