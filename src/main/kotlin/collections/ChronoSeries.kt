package mather.temporal.collections

import mather.temporal.ChronoRange
import java.time.temporal.Temporal

/**
 * A collection that holds periodised data, mapped by [ChronoRange] and accessed by a compatible [Temporal].
 */
abstract class ChronoSeries<K, R : ChronoRange<K>, T>(private val map: MutableMap<R, T>) where K : Comparable<K>,
                                                                                               K : Temporal {
    operator fun get(time: K): T? = map[findKey(time)]

    operator fun set(range: R, value: T) {
        map[range] = value
    }

    private fun findKey(time: K) = strategy.select(map.filterKeys { time in it }.keys)

    fun getAll(time: K) = map.filterKeys { time in it }.values

    var strategy = ChronoSelectionStrategy.FIRST

    val entries: Set<Map.Entry<R,T>>
        get() = map.entries

    val keys: Set<R>
        get() = map.keys

    val values: Collection<T>
        get() = map.values

    /**
     * Removes all entries encompassed by the specified [ChronoRange].
     */
    fun remove(range: R) {
        map.keys.filter { range.compareTo(it) in -2..2 }.forEach { map.remove(it) }
    }

    /**
     * Removes the entry mapped to the specified key.
     */
    fun removeSpecific(key: R){
        map.remove(key)
    }

    /**
     * Removes all entries accessible at the specified [Temporal].
     */
    fun remove(time: K) {
        map.keys.filter { time in it }.forEach { map.remove(it) }
    }
}