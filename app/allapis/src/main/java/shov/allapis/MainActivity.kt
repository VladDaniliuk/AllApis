package shov.allapis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.view.WindowCompat
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import shov.allapis.ui.allapis.AllApisScreen
import shov.allapis.ui.navigation.Screens
import shov.allapis.ui.theme.AllApisTheme
import shov.allapis.ui.utils.CustomScaffold

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AllApisTheme {
                val navController = rememberAnimatedNavController()

                CustomScaffold {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screens.Main.name
                    ) {
                        composable(Screens.Main.name) {
                            AllApisScreen(navController = navController)
                        }
                        composable(Screens.Settings.name) {

                        }
                    }
                }
            }
        }
    }
}
