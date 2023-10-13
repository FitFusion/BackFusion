package ch.fitfusion.backfusion.api.dtos

import ch.fitfusion.backfusion.api.validation.ValidationResult

class ValidationDTO(
    validationResult: ValidationResult
) : OutDTO(validationResult)
