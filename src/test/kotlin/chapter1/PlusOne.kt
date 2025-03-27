package chapter1

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.random.Random
import kotlin.test.Test

class PlusOneTest {

    @Test
    fun testPlusOne() {
        val a = Random.nextInt(0, 101)
        val b = Random.nextInt(0, 101)

        val smaller = minOf(a, b)
        val larger = maxOf(a, b)

        val result = plusOneEqual(smaller, larger)

        assertEquals(result, larger)
    }

    @Test
    fun testSameNumber() {
        val a = Random.nextInt(0, 101)
        assertEquals(a, plusOneEqual(a, a))
    }

    private fun plusOneEqual(smaller: Int, larger: Int): Int {
        var smaller = smaller

        while (smaller < larger) {
            smaller++
        }

        return smaller
    }
}