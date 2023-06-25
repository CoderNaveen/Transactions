package com.naveenkumawat.transactions.util

import java.util.*

fun formatDate(date: Long): String {
    val calendar = Calendar.getInstance().apply {
        timeInMillis = date
    }
    val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
    val month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
    val year = calendar[Calendar.YEAR]

    val formattedDate = getFormattedDate(dayOfMonth)
    val formattedMonth = month?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    return "$formattedDate $formattedMonth, $year"
}

fun getFormattedDate(day: Int): String {
    return when {
        day in 11..13 -> "${day}th"
        day % 10 == 1 -> "${day}st"
        day % 10 == 2 -> "${day}nd"
        day % 10 == 3 -> "${day}rd"
        else -> "${day}th"
    }
}