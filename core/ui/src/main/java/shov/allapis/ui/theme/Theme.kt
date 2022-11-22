package shov.allapis.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import shov.allapis.datastore.THEME

@Composable
fun AllApisTheme(modifier: Modifier = Modifier, content: @Composable (modifier: Modifier) -> Unit) {
    val themeViewModel = hiltViewModel<ThemeViewModel>()
    val context = LocalContext.current
    val theme by themeViewModel.theme.collectAsState()
    val isDynamicColor by themeViewModel.isDynamicColor.collectAsState()

    val isDarkTheme = if (theme == THEME.SYSTEM) isSystemInDarkTheme() else theme == THEME.DARK

    val colorScheme = when {
        isDynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (isDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        isDarkTheme -> DarkColors
        else -> LightColors
    }

    val systemUiController = rememberSystemUiController()

    DisposableEffect(key1 = systemUiController, key2 = isDarkTheme.not()) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = isDarkTheme.not()
        )
        onDispose { }
    }

    AllApisThemeContent(colorScheme = colorScheme, modifier = modifier, content = content)
}

@Composable
fun AllApisThemeContent(
    colorScheme: ColorScheme,
    modifier: Modifier = Modifier,
    content: @Composable (modifier: Modifier) -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography
    ) {
        content(modifier = modifier)
    }
}
