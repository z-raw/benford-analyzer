package com.benfordanalyzer.services

import kotlin.math.log10

class BenfordUtils {

    fun getObservedValues(firstDigits: List<Int>): List<Long> {
        val observedMap = firstDigits.groupBy { it }
            .filter { it.key in 1..9 }
            .mapValues { it.value.size.toLong() }

        val emptyMap = (1..9).associateWith { 0L }

        return emptyMap
            .plus(observedMap) // Incase some digits are missing in observedMap
            .toSortedMap()
            .values
            .toList()
    }

    fun getExpectedValues(totalNumbers: Int): List<Double> {
        return benfordsPercentages.map { it * totalNumbers }
    }

    companion object {
        val benfordsPercentages by lazy {
            (1..9).map { log10(1.0 + 1.0 / it) }
        }
    }
}