package shov.allapis.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import shov.allapis.datastore.DataStorePreferences
import shov.allapis.datastore.THEME
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(dataStorePreferences: DataStorePreferences) : ViewModel() {
    val theme: StateFlow<THEME> = dataStorePreferences.theme
        .stateIn(viewModelScope, SharingStarted.Lazily, THEME.SYSTEM)

    val isDynamicColor: StateFlow<Boolean> = dataStorePreferences.isDynamicColor
        .stateIn(viewModelScope, SharingStarted.Lazily, true)
}
