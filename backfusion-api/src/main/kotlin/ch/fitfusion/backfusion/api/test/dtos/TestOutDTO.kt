package ch.fitfusion.backfusion.api.test.dtos

import ch.fitfusion.backfusion.api.common.dtos.ValidationResult

class TestOutDTO(
    val testDTO: TestDTO,
    val validationResult: ValidationResult = ValidationResult.ok(),
)
