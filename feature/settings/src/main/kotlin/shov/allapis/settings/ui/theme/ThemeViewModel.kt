package shov.allapis.settings.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import shov.allapis.datastore.DataStorePreferences
import shov.allapis.datastore.THEME
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val dataStorePreferences: DataStorePreferences
) : ViewModel() {
    fun setTheme(theme: THEME) {
        viewModelScope.launch {
            dataStorePreferences.setTheme(theme)
        }
    }

    val theme: StateFlow<THEME> = dataStorePreferences.theme
        .stateIn(viewModelScope, SharingStarted.Eagerly, THEME.SYSTEM)
}
