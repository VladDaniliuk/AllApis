package shov.allapis.ui.allapis

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.VideoFile
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import shov.allapis.R
import shov.allapis.data.ApiCategory
import shov.allapis.data.ApiItem
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AllApisScreen(elements: Map<ApiCategory, List<ApiItem>>, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    LazyColumn(modifier = modifier.fillMaxSize()) {
        elements.forEach { (category, items) ->
            stickyHeader {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            modifier = Modifier.padding(all = 4.dp),
                            imageVector = category.icon,
                            contentDescription = null
                        )
                        Text(
                            text = context.getString(category.nameId),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }

            items(items) { item ->
                Column(modifier = Modifier.padding(horizontal = 4.dp)) {
                    Text(
                        text = context.getString(item.name),
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = context.getString(item.description),
                        style = MaterialTheme.typography.titleSmall
                    )

                    Divider(modifier = Modifier.padding(horizontal = 4.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AllApisPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    val elements = mapOf(
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

    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) { paddingValues ->
        AllApisScreen(elements, Modifier.padding(paddingValues))
    }
}
