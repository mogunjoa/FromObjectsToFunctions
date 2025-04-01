package chapter3

import com.ubertob.pesticide.core.DdtActions
import com.ubertob.pesticide.core.DdtProtocol
import org.mogun.chapter3.Item

interface CashierActions: DdtActions<DdtProtocol> {
    fun setupPrices(prices: Map<Item, Double>)
    fun totalFor(actorName: String): Double
    fun addItem(actorName: String, qty: Int, item: Item)
}

