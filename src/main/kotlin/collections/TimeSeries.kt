package mather.temporal.collections

import mather.temporal.TimeRange
import java.time.LocalTime

/**
 * [LocalTime] implementation of a [ChronoSeries].
 */
class TimeSeries<T>(map: MutableMap<TimeRange, T> = mutableMapOf()) : ChronoSeries<LocalTime, TimeRange, T>(map)