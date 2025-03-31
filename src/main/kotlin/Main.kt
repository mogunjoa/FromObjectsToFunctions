package org.mogun

import org.mogun.chapter2.RPNCalculator.calc

fun main() {
    val res4 = calc("2 5 * 4 + 3 2 * 1 + %")
    println(res4)
}

data class BowlingGameFP(val rolls: List<Int>) {
    fun roll(pins: Int): BowlingGameFP
    = copy(rolls = rolls + pins)
}

data class BowlingGameMutable(val rolls: MutableList<Int>) {
    fun roll(pins: Int): BowlingGameMutable {
        rolls.add(pins)
        return this
    }
}