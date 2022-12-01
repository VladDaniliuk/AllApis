package shov.allapis.ui.allapis

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import shov.allapis.R
import shov.allapis.data.ApiItem
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@OptIn(ExperimentalMaterial3Api::class)
fun LazyListScope.allApisItems(items: List<ApiItem>) {
    items(
        count = items.size,
        key = { index: Int ->
            items[index].name
        }
    ) { index: Int ->
        ListItem(
            headlineText = {
                Text(LocalContext.current.getString(items[index].name))
            },
            supportingText = {
                Text(LocalContext.current.getString(items[index].description))
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AllApisItemsPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        LazyColumn {
            allApisItems(
                listOf(
                    ApiItem(R.string.app_name, R.string.app_name),
                    ApiItem(R.string.anime_for_test, R.string.app_name)
                )
            )
        }
    }
}
