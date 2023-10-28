package ch.fitfusion.backfusion.account.services.validation

import ch.fitfusion.backfusion.account.services.validation.types.AccountValidationField.*
import ch.fitfusion.backfusion.account.services.validation.types.AccountValidationReason.EMAIL_INVALID
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.common.services.ValidatorBase
import ch.fitfusion.backfusion.api.validation.ValidationResult
import ch.fitfusion.backfusion.common.validation.types.CommonValidationField.DTO
import ch.fitfusion.backfusion.common.validation.types.CommonValidationReason.MANDATORY
import ch.fitfusion.backfusion.validation.Validator
import org.springframework.stereotype.Component

@Component
class AccountValidator : ValidatorBase<AccountInDTO> {

    override fun validate(dto: AccountInDTO): ValidationResult {

        val result = ValidationResult.ok()

        Validator.reject(dto).ifNull()
            .field(DTO)
            .reason(MANDATORY)
            .finish(result)

        if (result.isNotOk()) {
            return result
        }

        validateEmail(dto.email, result)

        Validator.reject(dto.username).ifNullOrBlank()
            .field(USERNAME)
            .reason(MANDATORY)
            .finish(result)

        Validator.reject(dto.password).ifNullOrBlank()
            .field(PASSWORD)
            .reason(MANDATORY)
            .finish(result)

        return result
    }

    fun validateEmail(email: String?, result: ValidationResult) {

        Validator.reject(email).ifNullOrBlank()
            .field(EMAIL)
            .reason(MANDATORY)
            .finish(result)

        Validator.rejectEmail(email).ifInvalid()
            .field(EMAIL)
            .reason(EMAIL_INVALID)
            .finish(result)
    }
}
