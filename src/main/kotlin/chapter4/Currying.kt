package org.mogun.chapter4

fun <A, B, C> ((A, B) -> C).curry(): (A) -> (B) -> C = { a: A -> { b: B -> this(a, b) } }

infix fun <A, B> ((A) -> B).`+++`(a: A): B = this(a)