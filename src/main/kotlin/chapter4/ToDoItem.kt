package org.mogun.chapter4

enum class ToDoStatus { InProgress, Blocked }

data class ToDoItem(
    val description: String,
    val status: ToDoStatus,
)

fun <T> T.discardUnless(predicate: T.() -> Boolean): T? = if(predicate(this)) this else null
