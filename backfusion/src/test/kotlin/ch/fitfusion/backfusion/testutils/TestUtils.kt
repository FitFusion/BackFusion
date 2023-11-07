package ch.fitfusion.backfusion.testutils

import java.util.*

fun getDefaultDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.set(1963, 5, 23)
    return calendar.time
}
