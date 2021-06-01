package mather.temporal.collections

import mather.temporal.ChronoRange
import java.time.temporal.Temporal

enum class ChronoSelectionStrategy {
    FIRST {
        override fun <R: Temporal, T : ChronoRange<R>> select(list: Collection<T>): T {
            return list.minByOrNull { it }!!
        }
    },
    LAST {
        override fun <R : Temporal, T : ChronoRange<R>> select(list: Collection<T>): T {
            return list.maxByOrNull { it }!!
        }
    },
    INNER {
        override fun <R : Temporal, T : ChronoRange<R>> select(list: Collection<T>): T {
            return list.reduce { l, r ->
                when {
                    l in r -> l
                    r in l -> r
                    l.start in r -> l
                    r.start in l -> r
                    l.endInclusive in r -> l
                    else -> r
                }
            }
        }
    },
    OUTER {
        override fun <R : Temporal, T : ChronoRange<R>> select(list: Collection<T>): T {
            return list.reduce { l, r ->
                when {
                    l in r -> r
                    r in l -> l
                    l.start in r -> r
                    r.start in l -> l
                    l.endInclusive in r -> r
                    else -> l
                }
            }
        }
    };
    abstract fun <R: Temporal, T : ChronoRange<R>> select(list: Collection<T>): T
}