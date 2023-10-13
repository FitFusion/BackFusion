package ch.fitfusion.backfusion.services

import ch.fitfusion.backfusion.api.dtos.AccountDTO
import ch.fitfusion.backfusion.api.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.dtos.ValidationDTO
import ch.fitfusion.backfusion.api.services.AccountService
import ch.fitfusion.backfusion.api.validation.ValidationResult
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl : AccountService {

    override fun register(): AccountOutDTO {
        return AccountOutDTO(AccountDTO("", ""), ValidationResult.withError("Error"))
    }

    override fun validateEmail(): ValidationDTO {
        return ValidationDTO(ValidationResult.ok())
    }

    override fun updateAccount(account: AccountDTO): AccountOutDTO {
        return AccountOutDTO(AccountDTO("", ""))
    }
}
