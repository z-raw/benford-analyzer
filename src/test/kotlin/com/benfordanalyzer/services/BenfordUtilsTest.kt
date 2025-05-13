package com.benfordanalyzer.services

import org.junit.Assert.assertEquals
import org.junit.Test

class BenfordUtilsTest {

    private val calculator = BenfordUtils()

    @Test
    fun `getObservedValues should return correct counts`() {
        val firstDigits = listOf(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
        val expected = listOf(1L, 2L, 3L, 4L, 0L, 0L, 0L, 0L, 0L)
        val result = calculator.getObservedValues(firstDigits)
        assertEquals(expected, result)
    }

    @Test
    fun `getExpectedValues should return correct expected counts`() {
        val totalNumbers = 100
        val expected = BenfordUtils.benfordsPercentages.map { it * totalNumbers }
        val result = calculator.getExpectedValues(totalNumbers)
        assertEquals(expected, result)
    }
}