package ch.fitfusion.backfusion.services

import ch.fitfusion.backfusion.api.dtos.AccountDTO
import ch.fitfusion.backfusion.api.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.dtos.ValidationDTO
import ch.fitfusion.backfusion.api.services.AccountService
import ch.fitfusion.backfusion.api.validation.ValidationResult
import ch.fitfusion.backfusion.auth.rbac.repositories.AccountRepository
import ch.fitfusion.backfusion.auth.rbac.services.UserDetailsServiceImpl
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
) : AccountService {

    override fun register(): AccountOutDTO {

        val acc = accountRepository.findByUsername("admin")

        if (acc.isEmpty) {
            val accountDTO = AccountDTO("NO", "SUPPLIED")
            return AccountOutDTO(accountDTO, ValidationResult.withError("NO ACCOUNT"))
        }

        return AccountOutDTO(AccountDTO(acc.get().email, acc.get().password), ValidationResult.withError("Error"))
    }

    override fun validateEmail(): ValidationDTO {
        return ValidationDTO(ValidationResult.ok())
    }

    override fun updateAccount(account: AccountDTO): AccountOutDTO {
        return AccountOutDTO(AccountDTO("", ""))
    }
}
