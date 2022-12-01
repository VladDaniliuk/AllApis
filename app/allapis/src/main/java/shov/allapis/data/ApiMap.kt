package shov.allapis.data

import androidx.compose.runtime.Immutable

@Immutable
data class ApiMap(val items: Map<ApiCategory, List<ApiItem>>)
