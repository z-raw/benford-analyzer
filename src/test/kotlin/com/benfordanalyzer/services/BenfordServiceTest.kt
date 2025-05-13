package com.benfordanalyzer.services

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.apache.commons.math3.stat.inference.ChiSquareTest
import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertContains

class BenfordServiceTest {

    private val digitExtractor = mockk<DigitExtractor>()
    private val calculator = mockk<BenfordUtils>()
    private val chiSquareTest = mockk<ChiSquareTest>()
    private val service = BenfordService(digitExtractor, calculator, chiSquareTest)

    @Test
    fun `analyze should return correct result when data does not follow Benford's Law`() = runBlocking {
        val documentText = "123, 456, 789"
        val significance = 0.05
        val firstDigits = listOf(1, 4, 7)
        val observedCounts = listOf(1L, 0L, 0L, 1L, 0L, 0L, 1L, 0L, 0L)
        val expectedCounts = listOf(30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6)

        every { digitExtractor.extractFirstDigits(documentText) } returns firstDigits
        every { calculator.getObservedValues(firstDigits) } returns observedCounts
        every { calculator.getExpectedValues(firstDigits.size) } returns expectedCounts
        every {
            chiSquareTest.chiSquareTest(
                expectedCounts.toDoubleArray(),
                observedCounts.toLongArray(),
                significance
            )
        } returns true

        val result = service.analyze(documentText, significance)

        assertEquals(false, result.followsBenfordsLaw)
        assertEquals(9, result.distribution.size)
        assertContains(
            result.message,
            "The data does NOT appear to follow Benford's Law at the 5.0% significance level."
        )

        verify(exactly = 1) { digitExtractor.extractFirstDigits(documentText) }
        verify(exactly = 1) { calculator.getObservedValues(firstDigits) }
        verify(exactly = 1) { calculator.getExpectedValues(firstDigits.size) }
        verify(exactly = 1) {
            chiSquareTest.chiSquareTest(
                expectedCounts.toDoubleArray(),
                observedCounts.toLongArray(),
                significance
            )
        }
    }

    @Test
    fun `analyze should return warning when data points are less than 50`() = runBlocking {
        val documentText = "12, 34"
        val significance = 0.05
        val firstDigits = listOf(1, 3)
        val observedCounts = listOf(1L, 0L, 1L, 0L, 0L, 0L, 0L, 0L, 0L)
        val expectedCounts = listOf(30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6)

        every { digitExtractor.extractFirstDigits(documentText) } returns firstDigits
        every { calculator.getObservedValues(firstDigits) } returns observedCounts
        every { calculator.getExpectedValues(firstDigits.size) } returns expectedCounts
        every {
            chiSquareTest.chiSquareTest(
                expectedCounts.toDoubleArray(),
                observedCounts.toLongArray(),
                significance
            )
        } returns true
        every {
            chiSquareTest.chiSquareTest(
                expectedCounts.toDoubleArray(),
                observedCounts.toLongArray()
            )
        } returns 0.1

        val result = service.analyze(documentText, significance)

        assertEquals(false, result.followsBenfordsLaw)
        assertContains(result.message, WARNING_LOW_DATA_POINTS)

        verify { digitExtractor.extractFirstDigits(documentText) }
        verify { calculator.getObservedValues(firstDigits) }
        verify { calculator.getExpectedValues(firstDigits.size) }
        verify {
            chiSquareTest.chiSquareTest(
                expectedCounts.toDoubleArray(),
                observedCounts.toLongArray(),
                significance
            )
        }
    }

    @Test
    fun `analyze should return message when no numbers are found`() = runBlocking {
        val documentText = "No numbers here!"
        val significance = 0.05

        every { digitExtractor.extractFirstDigits(documentText) } returns emptyList()

        val result = service.analyze(documentText, significance)

        assertEquals(false, result.followsBenfordsLaw)
        assertEquals(ERROR_NO_NUMBERS_FOUND, result.message)

        verify { digitExtractor.extractFirstDigits(documentText) }
    }
}