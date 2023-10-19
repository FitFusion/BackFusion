package ch.fitfusion.backfusion.account.services

import ch.fitfusion.backfusion.account.mappers.AccountMapper
import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.account.services.AccountService
import ch.fitfusion.backfusion.api.common.dtos.ValidationDTO
import ch.fitfusion.backfusion.api.common.dtos.ValidationResult
import ch.fitfusion.backfusion.auth.rbac.entities.Account
import ch.fitfusion.backfusion.auth.rbac.repositories.AccountRepository
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper,
) : AccountService {

    override fun register(accountIn: AccountInDTO): AccountOutDTO {

        val account = Account()
        account.email = accountIn.email
        account.password = accountIn.password
        account.username = accountIn.username

        val save = accountRepository.save(account)

        return AccountOutDTO(AccountDTO(save.username, save.email), ValidationResult.withError("Error"))
    }

    override fun getAccount(id: Long): AccountDTO? {

        val account = accountRepository.findById(id)
            .orElse(null) ?: return null

        return accountMapper.toDTO(account)
    }

    override fun validateEmail(email: String): ValidationDTO {
        return ValidationDTO(ValidationResult.ok())
    }

    override fun updateAccount(account: AccountDTO): AccountOutDTO {
        return AccountOutDTO(AccountDTO("", ""))
    }
}
