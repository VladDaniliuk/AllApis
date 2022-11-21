package shov.allapis.ui.allapis

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.VideoFile
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import shov.allapis.R
import shov.allapis.data.ApiCategory
import shov.allapis.data.ApiItem
import shov.allapis.data.ApiMap
import javax.inject.Inject

@HiltViewModel
class AllApisViewModel @Inject constructor() : ViewModel() {
    val apiMap = ApiMap(
        mapOf(
            ApiCategory(R.string.animals, Icons.Rounded.Pets) to listOf(
                ApiItem(R.string.cataas, R.string.cataas_description),
                ApiItem(R.string.adoptapet_for_test, R.string.cataas_description)
            ),
            ApiCategory(R.string.anime_for_test, Icons.Rounded.VideoFile) to listOf(
                ApiItem(R.string.aniapi_for_test, R.string.cataas_description),
                ApiItem(R.string.anidb_for_test, R.string.cataas_description)
            )
        )
    )
}
