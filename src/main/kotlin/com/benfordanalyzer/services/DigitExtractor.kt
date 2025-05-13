package com.benfordanalyzer.services

class DigitExtractor {

    /**
     * This regex will match only numbers, including decimal numbers and negative numbers and leading 0s.
     * It will not match numbers with commas or other non-numeric characters.
     *
     * Examples:
     *  "123" -> valid
     *  "-123.45" -> valid
     *  "123,45" -> valid (parsed as "123" and "45")
     *  "000" -> valid
     *  "123.45.67" -> invalid
     *  "A-123" -> invalid
     *  "123ABC" -> invalid
     */
    private val regex = """[+-]?\d+(\.\d+)?""".toRegex()

    fun extractFirstDigits(text: String): List<Int> {
        return text.split(" ",",","\n") // Split by space, comma, or newline
            .asSequence() // Use sequence to optimize call chain perf
            .filter {  regex.matches(it)} // Filter only valid numbers
            .map { if (it.startsWith('+') || it.startsWith('-')) it.substring(1) else it } // Remove sign
            .map { it.trimStart { char -> char == '0' } } // Remove leading zeros
            .filterNot { it.isEmpty() } // Filter out empty strings
            .map { it.first() } // Get the first char of each string
            .filter { it.isDigit() } // Filter out non-digit characters
            .map { it - '0' } // Convert char to int
            .toList()
    }
}