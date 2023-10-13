package ch.fitfusion.backfusion.api.dtos

import ch.fitfusion.backfusion.api.validation.ValidationResult

class TestOutDTO(
    private val testDTO: TestDTO,
    validationResult: ValidationResult = ValidationResult.ok(),
) : OutDTO(validationResult)
