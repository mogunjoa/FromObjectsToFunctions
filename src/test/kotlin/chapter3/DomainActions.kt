package chapter3

import com.ubertob.pesticide.core.DdtProtocol
import com.ubertob.pesticide.core.DomainOnly
import com.ubertob.pesticide.core.DomainSetUp
import com.ubertob.pesticide.core.Ready
import org.mogun.chapter3.Cashier
import org.mogun.chapter3.Item

val allActions = setOf(DomainActions)

object DomainActions : CashierActions {

    val cashier = Cashier()

    override fun setupPrices(prices: Map<Item, Double>) {
        cashier.putAll(prices)
    }

    override fun totalFor(actorName: String): Double =
        cashier.totalFor(actorName)

    override fun addItem(actorName: String, qty: Int, item: Item) =
        cashier.addItem(actorName, qty, item)

    override val protocol: DdtProtocol
        get() = DomainOnly

    override fun prepare(): DomainSetUp = Ready
}