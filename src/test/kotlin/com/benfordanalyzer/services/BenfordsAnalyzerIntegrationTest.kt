package com.benfordanalyzer.services

import com.benfordanalyzer.fixtures.BenfordsDataSets
import io.ktor.server.testing.*
import org.apache.commons.math3.stat.inference.ChiSquareTest
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertContains

class BenfordsAnalyzerIntegrationTest {

    private val digitExtractor = DigitExtractor()
    private val calculator = BenfordUtils()
    private val chiSquareTest = ChiSquareTest()
    private val service = BenfordService(digitExtractor, calculator, chiSquareTest)

    @Test
    fun `analyze should return correct result for countries area dataset`() = testApplication {
        val documentText = BenfordsDataSets.COUNTRIES_AREA
        val significance = 0.05

        val result = service.analyze(documentText, significance)

        assertEquals(true, result.followsBenfordsLaw)
        assertEquals(9, result.distribution.size)
        assert(result.message.contains("The data appears to follow Benford's Law"))
    }

    @Test
    fun `analyze should return true for the cricketers lifetime runs dataset`() = testApplication {

        val filePath = "src/test/kotlin/com/benfordanalyzer/fixtures/cricketor_runs_mini.txt"
        val documentText = File(filePath).readLines().joinToString(" ")
        val significance = 0.05

        val result = service.analyze(documentText, significance)

        assertEquals(true, result.followsBenfordsLaw)
        assertEquals(9, result.distribution.size)
    }

    @Test
    fun `analyze should return warning for less than 50 data points`() = testApplication {
        val documentText = "12, 34"
        val significance = 0.05

        val result = service.analyze(documentText, significance)

        assertEquals(true, result.followsBenfordsLaw)
        assertContains(result.message, WARNING_LOW_DATA_POINTS)
    }

    @Test
    fun `analyze should return erro message for no numbers`() = testApplication {
        val documentText = "No numbers here"
        val significance = 0.05

        val result = service.analyze(documentText, significance)

        assertEquals(false, result.followsBenfordsLaw)
        assertEquals(ERROR_NO_NUMBERS_FOUND, result.message)
    }

    @Test
    fun `analyze should return false for randomly generated numbers`() = testApplication {
        val randomNumbers = (1..1000).map { (1..9).random() }.joinToString(" ")
        val significance = 0.2

        val result = service.analyze(randomNumbers, significance)

        assertEquals(false, result.followsBenfordsLaw)
    }
}