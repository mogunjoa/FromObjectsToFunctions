package org.mogun.chapter4

import org.mogun.chapter3.StringTag
import org.mogun.chapter3.renderTemplate

data class Person(
    val firstName: String,
    val familyName: String
)


data class EmailTemplate(private val template: String) : (Person) -> String {
    override fun invoke(aPerson: Person): String = renderTemplate(template, aPerson.toTags())
}

private fun Person.toTags(): Map<String, StringTag> =
    mapOf(
        "firstName" to StringTag(firstName),
        "familyName" to StringTag(familyName)
    )