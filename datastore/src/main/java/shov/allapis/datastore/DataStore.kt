package shov.allapis.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Instance of DataStore
 */
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "SETTINGS")

class DataStorePreferences(private val dataStore: DataStore<Preferences>) {
    /**
     * getting theme variant from data store.
     * default is **System**
     */
    val theme: Flow<THEME> = dataStore.data.map { preferences ->
        THEME.valueOf(preferences[stringPreferencesKey(KEY_THEME)] ?: THEME.SYSTEM.name)
    }

    /**
     * getting if app use dynamic color scheme or not from data store.
     * default is **True**
     * */
    val isDynamicColor: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[booleanPreferencesKey(KEY_DYNAMIC_COLOR)] ?: true
    }

    /**
     * set theme variant to data store.
     * @param theme new theme variant for app.
     * @sample THEME
     */
    suspend fun setTheme(theme: THEME) {
        dataStore.edit { mutablePreferences: MutablePreferences ->
            mutablePreferences[stringPreferencesKey(KEY_THEME)] = theme.name
        }
    }

    /**
     * Set dynamic color
     * @param isUsing boolean, if:
     * - **True** using Dynamic colors from wallpaper.
     * - **False** using Standard colors from application.
     */
    suspend fun setDynamicColor(isUsing: Boolean) {
        dataStore.edit { mutablePreferences: MutablePreferences ->
            mutablePreferences[booleanPreferencesKey(KEY_DYNAMIC_COLOR)] = isUsing
        }
    }
}
