@file:JvmName("Utils")

package com.scalar.api.core

import com.scalar.api.core.http.Headers
import com.scalar.api.errors.ScalarInvalidDataException
import java.net.URLEncoder
import java.util.Collections
import java.util.SortedMap
import java.util.SortedSet
import java.util.concurrent.locks.Lock

/**
 * Percent-encodes a cookie parameter's value as `encodeURIComponent` does.
 *
 * Cookie pairs share one `Cookie` header, so a raw `;` in a value (end-user input, as often as not)
 * would end the pair and add a cookie of its own — the client's session cookie among them. Every
 * character outside the unreserved set is encoded, which covers `;`, `,`, whitespace, quotes,
 * backslashes and control characters.
 */
internal fun encodeCookieValue(value: String): String =
    URLEncoder.encode(value, "UTF-8")
        .replace("+", "%20")
        .replace("%21", "!")
        .replace("%27", "'")
        .replace("%28", "(")
        .replace("%29", ")")
        .replace("%7E", "~")

internal fun <T : Any> T?.getOrThrow(name: String): T =
    this ?: throw ScalarInvalidDataException("`${name}` is not present")

internal fun <T> List<T>.toImmutable(): List<T> =
    if (isEmpty()) Collections.emptyList() else Collections.unmodifiableList(toList())

internal fun <V : Comparable<V>> SortedSet<V>.toImmutable(): SortedSet<V> =
    if (isEmpty()) Collections.emptySortedSet()
    else Collections.unmodifiableSortedSet(toSortedSet(comparator() ?: Comparator.naturalOrder()))

internal fun <K, V> Map<K, V>.toImmutable(): Map<K, V> =
    if (isEmpty()) immutableEmptyMap() else Collections.unmodifiableMap(toMap())

internal fun <K, V> immutableEmptyMap(): Map<K, V> = Collections.emptyMap()

internal fun <K : Comparable<K>, V> SortedMap<K, V>.toImmutable(): SortedMap<K, V> =
    if (isEmpty()) Collections.emptySortedMap()
    else Collections.unmodifiableSortedMap(toSortedMap(comparator()))

/**
 * Returns all elements that yield the largest value for the given function, or an empty list if
 * there are zero elements.
 *
 * This is similar to [Sequence.maxByOrNull] except it returns _all_ elements that yield the largest
 * value; not just the first one.
 */
internal fun <T, R : Comparable<R>> Sequence<T>.allMaxBy(selector: (T) -> R): List<T> {
    var maxValue: R? = null
    val maxElements = mutableListOf<T>()

    val iterator = iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        val value = selector(element)
        if (maxValue == null || value > maxValue) {
            maxValue = value
            maxElements.clear()
            maxElements.add(element)
        } else if (value == maxValue) {
            maxElements.add(element)
        }
    }

    return maxElements
}

/**
 * Returns whether [this] is equal to [other].
 *
 * This differs from [Object.equals] because it also deeply equates arrays based on their contents,
 * even when there are arrays directly nested within other arrays.
 */
internal infix fun Any?.contentEquals(other: Any?): Boolean =
    arrayOf(this).contentDeepEquals(arrayOf(other))

/**
 * Returns a hash of the given sequence of [values].
 *
 * This differs from [java.util.Objects.hash] because it also deeply hashes arrays based on their
 * contents, even when there are arrays directly nested within other arrays.
 */
internal fun contentHash(vararg values: Any?): Int = values.contentDeepHashCode()

/**
 * Returns a [String] representation of [this].
 *
 * This differs from [Object.toString] because it also deeply stringifies arrays based on their
 * contents, even when there are arrays directly nested within other arrays.
 */
internal fun Any?.contentToString(): String {
    var string = arrayOf(this).contentDeepToString()
    if (string.startsWith('[')) {
        string = string.substring(1)
    }
    if (string.endsWith(']')) {
        string = string.substring(0, string.length - 1)
    }
    return string
}

/** The first value of the header [name], throwing when the headers do not carry it. */
internal fun Headers.getRequiredHeader(name: String): String =
    values(name).firstOrNull() ?: throw ScalarInvalidDataException("Could not find $name header")

internal interface Enum

/**
 * Executes a suspending block of code while holding this lock.
 *
 * @param T the return type of the action
 * @param action the suspending function to execute while holding the lock
 * @return the result of executing the action
 */
internal suspend fun <T> Lock.withLockAsync(action: suspend () -> T): T {
    lock()
    return try {
        action()
    } finally {
        unlock()
    }
}
