package chapter3

import org.mogun.chapter3.renderTemplate
import org.mogun.chapter3.tag
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.test.Test

class E04_TemplateEngine {

    @Test
    fun `happy birthday template`() {
        val template = """
            Happy Birthday {name} {surname}!
            from {sender}.
            """.trimIndent()
        val data = mapOf(
            "name" tag "Uberto",
            "surname" tag "Barbini",
            "sender" tag "PragProg"
        )
        val actual = renderTemplate(template, data)
        val expected = """
            Happy Birthday Uberto Barbini!
            from PragProg.
            """.trimIndent()
        expectThat(actual).isEqualTo(expected)
    }
}