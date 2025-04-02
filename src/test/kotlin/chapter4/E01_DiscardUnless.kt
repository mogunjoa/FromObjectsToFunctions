package chapter4

import org.mogun.chapter4.ToDoItem
import org.mogun.chapter4.ToDoStatus
import org.mogun.chapter4.discardUnless
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.test.Test

class E01_DiscardUnless {

    @Test
    fun `discard unless`() {
        val itemInProgress = ToDoItem(
            "doing something",
            status = ToDoStatus.InProgress
        )
        val itemBlocked = ToDoItem(
            "must do something",
            status = ToDoStatus.Blocked
        )

        expectThat(
            itemInProgress.discardUnless { status == ToDoStatus.InProgress }
        ).isEqualTo(itemInProgress)

        expectThat(
            itemBlocked.discardUnless { status == ToDoStatus.InProgress }
        ).isEqualTo(null)
    }
}