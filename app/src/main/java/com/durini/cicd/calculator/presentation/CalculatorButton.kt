package com.durini.cicd.calculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.durini.cicd.calculator.domain.CalculatorAction

@Composable
fun CalculatorButton(
    action: CalculatorUiAction,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(action.highlightLevel.getBackgroundColor())
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (action.text != null) {
            Text(
                text = action.text,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                color = action.highlightLevel.getOnBackgroundColor()
            )
        } else {
            action.content()
        }
    }
}