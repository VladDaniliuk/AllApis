package shov.allapis.ui.allapis

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cabin
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
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@OptIn(ExperimentalFoundationApi::class)
fun LazyListScope.allApisStickyHeader(category: ApiCategory) {
    stickyHeader(key = category.nameId) {
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
                    text = LocalContext.current.getString(category.nameId),
                    style = MaterialTheme.typography.titleLarge
                )
            }
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
            allApisStickyHeader(ApiCategory(R.string.app_name, Icons.Rounded.Cabin))
        }
    }
}
