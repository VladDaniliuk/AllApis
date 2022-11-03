package shov.allapis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.VideoFile
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import shov.allapis.data.ApiCategory
import shov.allapis.data.ApiItem
import shov.allapis.ui.allapis.AllApisScreen
import shov.allapis.ui.allapis.ApiMap
import shov.allapis.ui.theme.AllApisTheme
import shov.allapis.ui.utils.CustomScaffold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AllApisTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CustomScaffold { paddingValues ->
                        val elements = ApiMap(
                            mapOf(
                                ApiCategory(R.string.animals, Icons.Rounded.Pets) to listOf(
                                    ApiItem(R.string.cataas, R.string.cataas_description),
                                    ApiItem(
                                        R.string.adoptapet_for_test,
                                        R.string.cataas_description
                                    )
                                ),
                                ApiCategory(
                                    R.string.anime_for_test,
                                    Icons.Rounded.VideoFile
                                ) to listOf(
                                    ApiItem(R.string.aniapi_for_test, R.string.cataas_description),
                                    ApiItem(R.string.anidb_for_test, R.string.cataas_description)
                                )
                            )
                        )

                        AllApisScreen(
                            modifier = Modifier.padding(paddingValues),
                            apiMap = elements
                        )
                    }
                }
            }
        }
    }
}
