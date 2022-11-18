package shov.allapis.datastore

/**
 * Key for data store preferences.
 * Save theme variant for application.
 * @return
 * - **THEME.DARK** if **Dark** theme is using.
 * - **THEME.LIGHT** if **Light** theme is using.
 * - **THEME.SYSTEM** if **System** theme is using.
 */
const val KEY_THEME = "key_theme"

enum class THEME {
    DARK,
    LIGHT,
    SYSTEM
}

/**
 * Key for data store preferences.
 * Save if app use dynamic colors or not.
 * @return
 * - **True** if app uses dynamic colors.
 * - **False** if app doesn't use dynamic colors.
 */
const val KEY_DYNAMIC_COLOR = "key_dynamic_color"

