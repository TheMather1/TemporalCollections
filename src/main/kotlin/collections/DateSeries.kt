package mather.temporal.collections

import mather.temporal.DateRange
import java.time.LocalDate

/**
 * [LocalDate] implementation of a [ChronoSeries].
 */
class DateSeries<T>(map: MutableMap<DateRange, T> = mutableMapOf()) : ChronoSeries<LocalDate, DateRange, T>(map)