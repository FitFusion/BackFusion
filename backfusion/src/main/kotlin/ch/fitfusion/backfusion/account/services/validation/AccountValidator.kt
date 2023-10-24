package ch.fitfusion.backfusion.account.services.validation

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.common.dtos.ValidationResult
import ch.fitfusion.backfusion.api.common.services.Validator
import org.springframework.stereotype.Component

@Component
class AccountValidator : Validator<AccountDTO> {

    override fun validate(dto: AccountDTO): ValidationResult {
        TODO("Not yet implemented")
    }
}
