package com.durini.cicd.calculator.domain

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ExpressionParserTest {

    private lateinit var parser: ExpressionParser

    @Test
    fun `Simple expression is properly parsed`() {
        // GIVEN
        parser = ExpressionParser("3+5-3x4/3")

        // DO SOMETHING
        val actual = parser.parse()

        // ASSERT
        val expected = listOf(
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(5.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Number(3.0),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.DIVIDE),
            ExpressionPart.Number(3.0)
        )

        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with parenthesis is properly parsed`() {
        // GIVEN
        parser = ExpressionParser("4-(4x5)")

        // DO SOMETHING
        val actual = parser.parse()

        // ASSERT
        val expected = listOf(
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Parentheses(ParenthesesType.Opening),
            ExpressionPart.Number(4.0),
            ExpressionPart.Op(Operation.MULTIPLY),
            ExpressionPart.Number(5.0),
            ExpressionPart.Parentheses(ParenthesesType.Closing)
        )

        assertThat(expected).isEqualTo(actual)
    }

    @Test
    fun `Expression with decimals is properly parsed`() {
        // GIVEN
        parser = ExpressionParser("3.5+5.25-3.2")

        // DO SOMETHING
        val actual = parser.parse()

        // ASSERT
        val expected = listOf(
            ExpressionPart.Number(3.5),
            ExpressionPart.Op(Operation.ADD),
            ExpressionPart.Number(5.25),
            ExpressionPart.Op(Operation.SUBTRACT),
            ExpressionPart.Number(3.2)
        )

        assertThat(expected).isEqualTo(actual)
    }
}