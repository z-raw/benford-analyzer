package com.benfordanalyzer.model

import kotlinx.serialization.Serializable

@Serializable
data class BenfordAnalysisRequest(
    val documentText: String,
    val significanceLevel: Double
)

@Serializable
data class DigitDistribution(
    val digit: Int,
    val actualCount: Long,
    val actualPercentage: Double,
    val expectedCount: Double,
    val expectedPercentage: Double
)

@Serializable
data class BenfordAnalysisResult(
    val followsBenfordsLaw: Boolean,
    val distribution: List<DigitDistribution>,
    val significanceLevel: Double,
    val message: String
)
