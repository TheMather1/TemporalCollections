package mather.temporal.collections

import mather.temporal.ChronoRange
import java.time.temporal.Temporal

/**
 * A collection that holds periodised data, mapped by [ChronoRange] and accessed by a compatible [Temporal].
 */
abstract class ChronoSeries<K, R : ChronoRange<K>, T>(private val map: MutableMap<R, T>) where K : Comparable<K>,
                                                                                               K : Temporal {
    operator fun get(time: K): T? = map.firstNotNullOfOrNull { (k, v) -> if (time in k) v else null }
    operator fun set(range: R, value: T) {
        remove(range)
        map[range] = value
    }

    /**
     * Removes all entries encompassed by the specified [ChronoRange].
     */
    fun remove(range: R) {
        map.keys.filter { range.compareTo(it) in -2..2 }.forEach { map.remove(it) }
    }

    /**
     * Removes all entries accessible at the specified [Temporal].
     */
    fun remove(time: K) {
        map.keys.filter { time in it }.forEach { map.remove(it) }
    }
}