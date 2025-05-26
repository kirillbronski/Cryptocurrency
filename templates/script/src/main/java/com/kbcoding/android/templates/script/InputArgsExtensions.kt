package com.kbcoding.android.templates.script

val InputArgs.camelCaseModuleName
    get() = outputModuleName
        .substringAfterLast(":")
        .split("-")
        .joinToString("") { it.capitalizeFirstLetter() }

val InputArgs.moduleReference
    get() = outputModuleName
        .drop(1)
        .replace(":", ".")
        .split("-")
        .joinToString("") { it.capitalizeFirstLetter() }
        .replaceFirstChar { it.lowercaseChar() }

private fun String.capitalizeFirstLetter() = replaceFirstChar { it.uppercaseChar() }
