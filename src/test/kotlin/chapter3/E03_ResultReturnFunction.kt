package chapter3

import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.test.Test

class E03_ResultReturnFunction {

    fun buildCharAtPos(s: String): (Int) -> Char = { index -> s[index] }

    @Test
    fun `0번째 문자열을 반환한다`() {
        val myChartAtPos = buildCharAtPos("Kotlin")
        expectThat(myChartAtPos(0)).isEqualTo('K')
    }
}