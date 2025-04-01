package org.mogun

import org.mogun.chapter2.RPNCalculator.calc

fun main() {
    sumAndLog(10, 2, ::println)
}

fun sumAndLog(a: Int, b: Int, log:(Int) -> Unit): Int = (a+b).also(log)

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