package org.mogun.chapter3

class Cashier {

    private val prices = mutableMapOf<Item, Double>()
    private val customerTotal = mutableMapOf<String, Double>()


    fun putAll(offers: Map<Item, Double>) {
        prices.putAll(offers)
        customerTotal.clear()
    }

    fun totalFor(actorName: String): Double =
        customerTotal[actorName] ?: 0.0

    fun addItem(actorName: String, qty: Int, item: Item) {
        customerTotal[actorName] = totalFor(actorName) + qty * price(item)
    }

    private fun price(item: Item) = prices[item] ?: 0.0
}