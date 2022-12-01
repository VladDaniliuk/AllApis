package shov.allapis.settings.ui.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import shov.allapis.settings.R
import shov.allapis.ui.utils.CustomLargeTopAppBar
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScaffold(
    popBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CustomLargeTopAppBar(
                title = stringResource(R.string.settings),
                canNavigateBack = true,
                onNavigateBack = popBackStack,
                scrollBehavior = scrollBehavior,
            )
        },
        content = content
    )
}

@Preview
@Composable
fun SettingsScaffoldPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        SettingsScaffold(popBackStack = {}) {}
    }
}
