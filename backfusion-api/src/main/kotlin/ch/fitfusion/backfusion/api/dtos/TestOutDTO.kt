package ch.fitfusion.backfusion.api.dtos

import ch.fitfusion.backfusion.api.validation.ValidationResult
import jdk.incubator.vector.VectorOperators.Test

class TestOutDTO(
    val testDTO: TestDTO,
    val validationResult: ValidationResult = ValidationResult.ok(),
)
