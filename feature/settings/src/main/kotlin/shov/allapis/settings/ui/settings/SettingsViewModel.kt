package shov.allapis.settings.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import shov.allapis.datastore.DataStorePreferences
import shov.allapis.datastore.THEME
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dataStorePreferences: DataStorePreferences
) : ViewModel() {
    val isDynamicColor: StateFlow<Boolean> = dataStorePreferences.isDynamicColor
        .stateIn(viewModelScope, SharingStarted.Lazily, true)

    fun setDynamicColor(newState: Boolean) {
        viewModelScope.launch {
            dataStorePreferences.setDynamicColor(newState)
        }
    }

    val theme: StateFlow<String> = dataStorePreferences.theme
        .map { theme -> theme.name.lowercase() }
        .stateIn(viewModelScope, SharingStarted.Lazily, THEME.SYSTEM.name.lowercase())
}
