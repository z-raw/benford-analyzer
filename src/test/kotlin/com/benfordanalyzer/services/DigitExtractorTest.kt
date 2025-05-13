package com.benfordanalyzer.services

import org.junit.Assert.assertEquals
import org.junit.Test

class DigitExtractorTest {

    private val extractor = DigitExtractor()

    @Test
    fun `extractFirstDigits should return correct digits`() {
        val text = "123, 045, -678, +90.12, 0.34"
        val expected = listOf(1, 4, 6, 9)
        val result = extractor.extractFirstDigits(text)
        assertEquals(expected, result)
    }

    @Test
    fun `extractFirstDigits should return empty list for no numbers`() {
        val text = "No numbers here!"
        val result = extractor.extractFirstDigits(text)
        assertEquals(emptyList<Int>(), result)
    }

    @Test
    fun `extractFirstDigits should handle leading zeros`() {
        val text = "000123, 045, -678, +90.12, 0.34"
        val expected = listOf(1, 4, 6, 9)
        val result = extractor.extractFirstDigits(text)
        assertEquals(expected, result)
    }

    @Test
    fun `extractFirstDigits should ignore invalid numbers with multiple decimals`() {
        val text = "123.45.67, -89.01.23"
        val result = extractor.extractFirstDigits(text)
        assertEquals(emptyList<Int>(), result)
    }

    @Test
    fun `extractFirstDigits should ignore invalid numbers with letters`() {
        val text = "123ABC, A-456, 78.9XYZ"
        val result = extractor.extractFirstDigits(text)
        assertEquals(emptyList<Int>(), result)
    }

    @Test
    fun `extractFirstDigits should handle mixed valid and invalid numbers`() {
        val text = "123 -456.78 +90.12 0.34, 1,234, ABC123"
        val expected = listOf(1, 4, 9, 1 , 2)
        val result = extractor.extractFirstDigits(text)
        assertEquals(expected, result)
    }

    @Test
    fun `extractFirstDigits should handle negative numbers`() {
        val text = "-123, -045, -678.90"
        val expected = listOf(1, 4, 6)
        val result = extractor.extractFirstDigits(text)
        assertEquals(expected, result)
    }

    @Test
    fun `extractFirstDigits should handle positive numbers with plus sign`() {
        val text = "+123, +045, +678.90"
        val expected = listOf(1, 4, 6)
        val result = extractor.extractFirstDigits(text)
        assertEquals(expected, result)
    }

    @Test
    fun `extractFirstDigits should handle empty input`() {
        val text = ""
        val result = extractor.extractFirstDigits(text)
        assertEquals(emptyList<Int>(), result)
    }

    @Test
    fun `extractFirstDigits should ignore invalid numbers`() {
        val text = "00ABC-123 456-ABC-789 11AA BB01 7ZZ"
        val result = extractor.extractFirstDigits(text)
        assertEquals(emptyList<Int>(), result)
    }


}