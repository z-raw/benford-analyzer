package com.benfordanalyzer.plugins

import com.benfordanalyzer.model.BenfordAnalysisRequest
import com.benfordanalyzer.services.BenfordUtils
import com.benfordanalyzer.services.BenfordService
import com.benfordanalyzer.services.DigitExtractor
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.http.*
import org.apache.commons.math3.stat.inference.ChiSquareTest

fun Application.configureRouting() {
    // TODO: Add Kodein or Koin DI
    val service = BenfordService(
        digitExtractor = DigitExtractor(),
        calculator = BenfordUtils(),
        chiSquareTester = ChiSquareTest()
    )

    routing {
        post("/api/analyze") {
            try {
                val request = call.receive<BenfordAnalysisRequest>()

                if (request.documentText.isBlank()) {
                    call.respond(HttpStatusCode.BadRequest, mapOf("error" to "Document text cannot be empty."))
                    return@post
                }
                if (request.significanceLevel <= 0 || request.significanceLevel >= 0.5) {
                    call.respond(HttpStatusCode.BadRequest, mapOf("error" to "Significance level must be a number between 0 and 0.5 (exclusive)"))
                    return@post
                }

                val result = service.analyze(request.documentText, request.significanceLevel)
                call.respond(result)

            } catch (e: ContentTransformationException) {
                application.log.error("Failed to transform request body for Benford analysis", e)
                call.respond(HttpStatusCode.BadRequest, mapOf("error" to "Invalid request body: ${e.message}"))
            } catch (e: Exception) {
                application.log.error("Error during Benford analysis", e)
                call.respond(HttpStatusCode.InternalServerError, mapOf("error" to (e.message ?: "An internal error occurred")))
            }
        }
    }
}
