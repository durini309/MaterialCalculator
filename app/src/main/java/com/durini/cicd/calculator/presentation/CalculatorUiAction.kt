package com.durini.cicd.calculator.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.durini.cicd.calculator.domain.CalculatorAction

data class CalculatorUiAction(
    val text: String?,
    val  highlightLevel: HighlightLevel,
    val action: CalculatorAction,
    val content: @Composable () -> Unit = {}
)

@Composable
fun HighlightLevel.getBackgroundColor() = when(this) {
    HighlightLevel.Neutral -> MaterialTheme.colorScheme.surfaceVariant
    HighlightLevel.SemiHighlighted -> MaterialTheme.colorScheme.inverseSurface
    HighlightLevel.Highlighted -> MaterialTheme.colorScheme.tertiary
    HighlightLevel.StronglyHighlighted -> MaterialTheme.colorScheme.primary
}

@Composable
fun HighlightLevel.getOnBackgroundColor() = when(this) {
    HighlightLevel.Neutral -> MaterialTheme.colorScheme.onSurfaceVariant
    HighlightLevel.SemiHighlighted -> MaterialTheme.colorScheme.inverseOnSurface
    HighlightLevel.Highlighted -> MaterialTheme.colorScheme.onTertiary
    HighlightLevel.StronglyHighlighted -> MaterialTheme.colorScheme.onPrimary
}

sealed interface HighlightLevel {
    object Neutral: HighlightLevel
    object SemiHighlighted: HighlightLevel
    object Highlighted: HighlightLevel
    object StronglyHighlighted: HighlightLevel
}