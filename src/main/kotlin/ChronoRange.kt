package mather.temporal

import java.time.temporal.Temporal

/**
 * Representation of [Temporal] range with a specified start and end.
 */
abstract class ChronoRange<T>(override val start: T, override val endInclusive: T): ClosedRange<T>, Comparable<ChronoRange<T>> where T : Comparable<T>, T : Temporal{
    /**
     * Checks whether the specified [value] is a subset of the range.
     */
    operator fun contains (value: ChronoRange<T>) = start < value.start && value.endInclusive > endInclusive

    /**
     * Compares this range with another range, returning the sum of twice the comparison of the starts and the comparison of the ends.
     */
    override operator fun compareTo (other: ChronoRange<T>) = (start.compareTo(other.start)*2) + endInclusive.compareTo(other.endInclusive)

    override fun equals(other: Any?): Boolean {
        return if(other is ChronoRange<*>) start == other.start && endInclusive === other.endInclusive
            else super.equals(other)
    }

    override fun hashCode(): Int {
        var result = start.hashCode()
        result = 31 * result + endInclusive.hashCode()
        return result
    }
}