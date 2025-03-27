package org.mogun

fun main() {
//    val g1 = BowlingGameMutable(mutableListOf()).roll(5).roll(4)
//    val g2 = BowlingGameMutable(mutableListOf(5, 4))

    val g1 = BowlingGameMutable(mutableListOf()).roll(5)
    val expected = BowlingGameMutable(mutableListOf()).roll(5).roll(4)

//    val g1 = BowlingGameFP(emptyList()).roll(5)
//    val expected = BowlingGameFP(emptyList()).roll(5).roll(4)

    println(g1)
    println(expected)

    println(g1.roll(4) == expected)

    println(g1)
    println(expected)

    println(g1.roll(4) == expected)

    println(g1)
    println(expected)
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