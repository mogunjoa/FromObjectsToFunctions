package chapter1

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.random.Random
import kotlin.test.Test

class CashRegister(
    private val priceInfo: Map<String, Double>,
    private val promotions: Map<String, String>
) {
    fun checkout(items: List<String>): Double {
        var total = 0.0
        // 각 상품의 개수를 카운트
        val counts = items.groupingBy { it }.eachCount()

        for ((item, count) in counts) {
            val price = priceInfo[item] ?: 0.0
            if (promotions.containsKey(item)) {
                val promo = promotions[item]!!
                // "MxN" 형태를 파싱 (예, "3x2" -> M=3, N=2)
                val (m, n) = promo.split("x").map { it.toInt() }
                val groups = count / m
                val remainder = count % m
                total += groups * n * price + remainder * price
            } else {
                total += count * price
            }
        }
        return total
    }
}

class CashRegisterTest {

    @Test
    fun testNoPromotion() {
        // 0.5 ~ 2.0 사이의 임의의 가격 생성
        val breadPrice = Random.nextDouble(0.5, 2.0)
        val priceInfo = mapOf("bread" to breadPrice)
        val promotions = emptyMap<String, String>()
        val register = CashRegister(priceInfo, promotions)

        val items = listOf("bread", "bread", "bread")
        val expectedTotal = 3 * breadPrice
        assertEquals(expectedTotal, register.checkout(items), 0.0001)
    }

    @Test
    fun testWithPromotion() {
        // 1.0 ~ 3.0 사이의 임의의 가격 생성
        val milkPrice = Random.nextDouble(1.0, 3.0)
        val priceInfo = mapOf("milk" to milkPrice)
        val promotions = mapOf("milk" to "3x2")
        val register = CashRegister(priceInfo, promotions)

        val items = listOf("milk", "milk", "milk")
        val expectedTotal = 2 * milkPrice  // 3개 중 2개 가격만 적용
        assertEquals(expectedTotal, register.checkout(items), 0.0001)
    }

    @Test
    fun testPartialPromotion() {
        // 1.0 ~ 3.0 사이의 임의의 가격 생성
        val milkPrice = Random.nextDouble(1.0, 3.0)
        val priceInfo = mapOf("milk" to milkPrice)
        val promotions = mapOf("milk" to "3x2")
        val register = CashRegister(priceInfo, promotions)

        val items = listOf("milk", "milk", "milk", "milk")
        // 4개 구매 시: 3개는 프로모션 적용(2개 가격), 나머지 1개는 정가
        val expectedTotal = 2 * milkPrice + 1 * milkPrice
        assertEquals(expectedTotal, register.checkout(items), 0.0001)
    }
}