package com.shadcn.ui.kmp

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import java.awt.Toolkit
import java.time.format.DateTimeFormatter

actual fun platform(): String = "JVM"

@Composable
actual fun getScreenWidth(): Dp {
    val density = LocalDensity.current
    val widthPx = Toolkit.getDefaultToolkit().screenSize.width
    return with(density) { widthPx.toDp() }
}

@Composable
actual fun getScreenHeight(): Dp {
    val density = LocalDensity.current
    val heightPx = Toolkit.getDefaultToolkit().screenSize.height
    return with(density) { heightPx.toDp() }
}

actual fun LocalDateTime.format(format: String): String {
    val formatter = DateTimeFormatter.ofPattern(format)
    return toJavaLocalDateTime().format(formatter)
}

actual fun LocalDate.format(format: String): String {
    val formatter = DateTimeFormatter.ofPattern(format)
    return toJavaLocalDate().format(formatter)
}

private fun LocalDateTime.toJavaLocalDateTime(): java.time.LocalDateTime {
    return java.time.LocalDateTime.of(
        year,
        monthNumber,
        dayOfMonth,
        hour,
        minute,
        second,
        nanosecond
    )
}

private fun LocalDate.toJavaLocalDate(): java.time.LocalDate {
    return java.time.LocalDate.of(year, monthNumber, dayOfMonth)
}
