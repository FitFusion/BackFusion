package ch.fitfusion.backfusion.api.dtos

import ch.fitfusion.backfusion.api.validation.ValidationResult

class AccountOutDTO(
    val accountDTO: AccountDTO?,
    val validationResult: ValidationResult = ValidationResult.ok()
)
