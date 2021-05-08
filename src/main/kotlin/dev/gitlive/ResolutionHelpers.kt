package dev.gitlive

import org.gradle.api.attributes.Attribute
import org.gradle.api.attributes.HasConfigurableAttributes
import org.jetbrains.kotlin.gradle.plugin.KotlinTarget

enum class JSType {
    Browser, Node;
}

val jsTypeAttribute = Attribute.of("dev.gitlive.jstype", JSType::class.java)

fun <T : HasConfigurableAttributes<*>> T.jsNode() = apply {
    attributes { it.attribute(jsTypeAttribute, JSType.Node) }
}

fun <T : HasConfigurableAttributes<*>> T.jsBrowser() = apply {
    attributes { it.attribute(jsTypeAttribute, JSType.Browser) }
}

fun <T : KotlinTarget> T.jsNode() = apply {
    attributes { attribute(jsTypeAttribute, JSType.Node) }
}

fun <T : KotlinTarget> T.jsBrowser() = apply {
    attributes { attribute(jsTypeAttribute, JSType.Browser) }
}