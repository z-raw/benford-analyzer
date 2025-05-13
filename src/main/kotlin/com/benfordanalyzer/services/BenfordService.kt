package com.benfordanalyzer.services

import com.benfordanalyzer.model.BenfordAnalysisResult
import com.benfordanalyzer.model.DigitDistribution
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.apache.commons.math3.stat.inference.ChiSquareTest

class BenfordService(
    private val digitExtractor: DigitExtractor,
    private val calculator: BenfordUtils,
    private val chiSquareTester: ChiSquareTest,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun analyze(documentText: String, significance: Double): BenfordAnalysisResult = withContext(dispatcher) {
        val firstDigits = digitExtractor.extractFirstDigits(documentText)
        val totalNumbers = firstDigits.size

        if (totalNumbers == 0) {
            return@withContext BenfordAnalysisResult(
                followsBenfordsLaw = false,
                distribution = emptyList(),
                significanceLevel = significance,
                message = ERROR_NO_NUMBERS_FOUND
            )
        }

        val observedCounts = calculator.getObservedValues(firstDigits)
        val expectedCounts = calculator.getExpectedValues(totalNumbers)

        // Our null hypothesis is that the data follows Benford's Law
        // chiSquareTest returns true iff null hypothesis can be rejected with confidence 1 - alpha
        // So we need to negate the result to get the correct interpretation
        val testResult = !chiSquareTester.chiSquareTest(
            expectedCounts.toDoubleArray(),
            observedCounts.toLongArray(),
            significance
        )
        
        var message = if (testResult) {
            "The data appears to follow Benford's Law at the ${significance * 100}% significance level."
        } else {
            "The data does NOT appear to follow Benford's Law at the ${significance * 100}% significance level."
        }
        
        if (totalNumbers < 50) {
            message += WARNING_LOW_DATA_POINTS
        }
        
        val distribution = (1..9).mapIndexed { index, digit ->
            DigitDistribution(
                digit = digit,
                actualCount = observedCounts[index],
                actualPercentage = (observedCounts[index].toDouble() / totalNumbers) * 100,
                expectedCount = expectedCounts[index],
                expectedPercentage = BenfordUtils.benfordsPercentages[index] * 100
            )
        }

        return@withContext BenfordAnalysisResult(
            followsBenfordsLaw = testResult,
            distribution = distribution,
            significanceLevel = significance,
            message = message
        )
    }
}

const val ERROR_NO_NUMBERS_FOUND = "No numbers found in the provided text."
const val WARNING_LOW_DATA_POINTS =
    " Warning: The number of data points is low (less than 50). Chi-square test results may not be reliable."