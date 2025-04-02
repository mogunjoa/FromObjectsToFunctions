package chapter4

import org.junit.jupiter.api.Test
import org.mogun.chapter4.EmailTemplate
import org.mogun.chapter4.Person
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class E04_InvokableTest {
    val john = Person("John", "Smith")
    val jane = Person("Jane", "Austen")

    @Test
    fun `correctly generate the email text`() {
        val templateText = "Dear {firstName}, ..."
        val emailTemplate = EmailTemplate(templateText)

        expectThat(emailTemplate(john)).isEqualTo("Dear John, ...")
        expectThat(emailTemplate(jane)).isEqualTo("Dear Jane, ...")
    }
}