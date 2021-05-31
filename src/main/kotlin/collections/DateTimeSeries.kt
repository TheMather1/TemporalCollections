package mather.temporal.collections

import mather.temporal.DateTimeRange
import java.time.LocalDateTime

/**
 * [LocalDateTime] implementation of a [ChronoSeries].
 */
class DateTimeSeries<T>(map: MutableMap<DateTimeRange, T> = mutableMapOf()) : ChronoSeries<LocalDateTime, DateTimeRange, T>(map)