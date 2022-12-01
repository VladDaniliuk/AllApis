package shov.allapis.ui.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import shov.allapis.ui.utils.CustomPreview
import shov.allapis.ui.utils.CustomPreviewParameterProvider

@Composable
fun StyledText(
    text: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: (TextLayoutResult) -> Unit = {}
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = textStyle.fontSize,
        fontStyle = textStyle.fontStyle,
        fontWeight = textStyle.fontWeight,
        fontFamily = textStyle.fontFamily,
        letterSpacing = textStyle.letterSpacing,
        textDecoration = textStyle.textDecoration,
        textAlign = textStyle.textAlign,
        lineHeight = textStyle.lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
        style = textStyle
    )
}

@Preview(showBackground = true)
@Composable
private fun TypographyTextPreview(
    @PreviewParameter(CustomPreviewParameterProvider::class) pairs: Pair<Boolean, Boolean>
) {
    CustomPreview(isDark = pairs.first, isDynamic = pairs.second) {
        StyledText("Styled text", textStyle = MaterialTheme.typography.titleLarge)
    }
}
