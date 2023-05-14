package com.durini.cicd.calculator.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.durini.cicd.calculator.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)
    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun enterExpression_correctResultDisplayed() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("2.0").assertIsDisplayed()
    }

    @Test
    fun pressAC_screenIsCleaned() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("3").performClick()

        composeRule.onNodeWithText("1+2x3").assertIsDisplayed()
        composeRule.onNodeWithText("AC").performClick()
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("1+").assertIsDisplayed()
    }
}