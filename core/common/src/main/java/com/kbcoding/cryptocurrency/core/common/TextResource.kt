package com.kbcoding.cryptocurrency.core.common

/**
 * Defines an abstract way to handle text resources within Android applications,
 * allowing for a unified approach to manage string literals and resource IDs.
 *
 * The sealed interface `TextResource` serves as a base for:
 * - `TextStringResource` for handling direct string literals.
 * - `TextIntResource` for referencing string resources by their IDs.
 *
 * This abstraction facilitates localization and dynamic content management by enabling
 * seamless interchangeability between different types of text sources.
 *
 * Usage example:
 * ```
 * fun Fragment.getStringFromTextResource(textResource: TextResource): String {
 *     return when (textResource) {
 *         is TextStringResource -> textResource.data
 *         is TextIntResource -> getString(textResource.data)
 *     }
 * }
 * ```
 *
 * @see TextStringResource
 * @see TextIntResource
 */
sealed interface TextResource

class TextStringResource(val data: String): TextResource

class TextIntResource(val data: Int): TextResource

fun Int.toTextResource(): TextResource = TextIntResource(this)

fun String.toTextResource(): TextResource = TextStringResource(this)