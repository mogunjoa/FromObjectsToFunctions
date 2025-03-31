package org.mogun.chapter2

object RPNCalculator {
    val operationMap = mapOf<String, (Double, Double) -> Double>(
        "+" to Double::plus,
        "-" to Double::minus,
        "*" to Double::times,
        "/" to Double::div,
    )

    val funStack = FunStack<Double>()

    fun calc(expo: String) = expo.split(" ")
        .fold(funStack, ::reduce)
        .pop().first

    fun reduce(stack: FunStack<Double>, token: String): FunStack<Double> =
        if(operationMap.containsKey(token)) {
            val (b, tempStack) = stack.pop()
            val (a, newStack) = tempStack.pop()
            newStack.push(operation(token, a, b))
        } else {
            val num = token.toDoubleOrNull() ?: error("Unknown operation $token")
            stack.push(num)
        }

    fun operation(token: String, operatorA: Double, operatorB: Double) =
        operationMap[token]?.invoke(operatorA, operatorB) ?: error("Unknown operation $token")
}