package mather.temporal

import java.time.LocalTime

/**
 * [LocalTime] implementation of a [ChronoRange].
 */
class TimeRange(start: LocalTime, endInclusive: LocalTime): ChronoRange<LocalTime>(start, endInclusive)