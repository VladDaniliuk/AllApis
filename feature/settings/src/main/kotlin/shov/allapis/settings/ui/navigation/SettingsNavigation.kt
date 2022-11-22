package shov.allapis.settings.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.dialog
import com.google.accompanist.navigation.animation.composable
import shov.allapis.settings.ui.settings.SettingsScreen
import shov.allapis.settings.ui.theme.ThemeScreen
import shov.allapis.ui.navigation.Screens

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.settingsComposable(navController: NavController) {
    composable(Screens.Settings.name) {
        SettingsScreen(navController = navController)
    }
    dialog(Screens.Theme.name) {
        ThemeScreen(navController = navController)
    }
}
