package shov.allapis.ui.allapis

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import shov.allapis.R
import shov.allapis.data.ApiItem
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

fun LazyListScope.allApisItems(items: List<ApiItem>) {
    items(items) { item ->
        Column(modifier = Modifier.padding(horizontal = 4.dp)) {
            Text(
                text = LocalContext.current.getString(item.name),
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = LocalContext.current.getString(item.description),
                style = MaterialTheme.typography.titleSmall
            )

            Divider(modifier = Modifier.padding(horizontal = 4.dp))
        }
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
                    ApiItem(R.string.app_name, R.string.app_name)
                )
            )
        }
    }
}
