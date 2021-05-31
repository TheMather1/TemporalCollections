package mather.temporal

import java.time.LocalDate

/**
 * [LocalDate] implementation of a [ChronoRange].
 */
class DateRange(start: LocalDate, endInclusive: LocalDate): ChronoRange<LocalDate>(start, endInclusive)