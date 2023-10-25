package ch.fitfusion.backfusion.account.services.validation

import ch.fitfusion.backfusion.account.services.validation.types.AccountValidationField.*
import ch.fitfusion.backfusion.account.services.validation.types.AccountValidationReason.STUPID
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.common.services.ValidatorBase
import ch.fitfusion.backfusion.api.validation.ValidationResult
import ch.fitfusion.backfusion.validation.Validator
import org.springframework.stereotype.Component

@Component
class AccountValidator : ValidatorBase<AccountInDTO> {

    override fun validate(dto: AccountInDTO): ValidationResult {

        val result = ValidationResult.ok()

        Validator.reject(dto.email).ifNull()
            .field(EMAIL)
            .reason(STUPID)
            .finish(result)

        Validator.reject(dto.username).ifNull()
            .field(USERNAME)
            .reason(STUPID)
            .finish(result)

        Validator.reject(dto.password).ifNull()
            .field(PASSWORD)
            .reason(STUPID)
            .finish(result)

        return result
    }
}
