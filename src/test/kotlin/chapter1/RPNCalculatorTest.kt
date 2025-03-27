package chapter1

import org.mogun.BowlingGameFP
import org.mogun.BowlingGameMutable
import org.mogun.chapter2.RPNCalculator
import kotlin.test.Test
import kotlin.test.assertEquals

class RPNCalculatorTest {

    @Test
    fun calculateTest() {
        val g1 = BowlingGameFP(emptyList()).roll(5)
        val expected = BowlingGameFP(emptyList()).roll(5).roll(4)

        assertEquals(expected, g1.roll(4))
        assertEquals(expected, g1.roll(4))
    }
}