package shov.allapis.ui.allapis

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import shov.allapis.ui.navigation.Screens
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@Composable
fun AllApisScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: AllApisViewModel = hiltViewModel()
) {
    AllApisScaffold(
        modifier = modifier,
        onSettingsNavigate = { navController.navigate(Screens.Settings.name) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            viewModel.apiMap.items.forEach { (category, items) ->
                allApisStickyHeader(category)

                allApisItems(items)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AllApisPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        AllApisScreen(rememberNavController())
    }
}
