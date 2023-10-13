package ch.fitfusion.backfusion.api.dtos

import ch.fitfusion.backfusion.api.validation.ValidationResult

class AccountOutDTO(
    private var accountDTO: AccountDTO,
    validationResult: ValidationResult = ValidationResult.ok()
) : OutDTO(validationResult)
