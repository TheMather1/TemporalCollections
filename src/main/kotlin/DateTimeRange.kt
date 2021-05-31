package mather.temporal

import java.time.LocalDateTime

/**
 * [LocalDateTime] implementation of a [ChronoRange].
 */
class DateTimeRange(start: LocalDateTime, endInclusive: LocalDateTime): ChronoRange<LocalDateTime>(start, endInclusive)