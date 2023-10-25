package ch.fitfusion.backfusion.account.services

import ch.fitfusion.backfusion.account.mappers.AccountMapper
import ch.fitfusion.backfusion.account.services.validation.AccountValidator
import ch.fitfusion.backfusion.account.util.AccountUtil
import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountOutDTO
import ch.fitfusion.backfusion.api.account.services.AccountService
import ch.fitfusion.backfusion.api.common.dtos.ValidationDTO
import ch.fitfusion.backfusion.api.validation.ValidationResult
import ch.fitfusion.backfusion.api.validation.ValidationResultEntry.Companion.error
import ch.fitfusion.backfusion.auth.rbac.exceptions.AccountNotFoundException
import ch.fitfusion.backfusion.auth.rbac.repositories.AccountRepository
import ch.fitfusion.backfusion.common.validation.types.CommonValidationField.ID
import ch.fitfusion.backfusion.common.validation.types.CommonValidationReason.MANDATORY
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val accountMapper: AccountMapper,
    private val validator: AccountValidator,
    private val accountUtil: AccountUtil,
) : AccountService {

    override fun register(accountIn: AccountInDTO): AccountOutDTO {

        val result = validator.validate(accountIn)

        if (result.isNotOk()) {
            return AccountOutDTO(null, result)
        }

        val save = accountRepository.save(accountMapper.toEntity(accountIn))

        return AccountOutDTO(AccountDTO(save.username, save.email), ValidationResult.ok())
    }

    override fun getAccount(id: Long): AccountDTO? {

        val account = accountRepository.findById(id)
            .orElse(null) ?: return null

        return accountMapper.toDTO(account)
    }

    override fun getAccount() = accountMapper.toDTO(accountUtil.getAccountFromContext())

    override fun validateEmail(email: String): ValidationDTO {

        val result = ValidationResult.ok()

        validator.validateEmail(email, result)

        return ValidationDTO(result)
    }

    override fun updateAccount(accountIn: AccountInDTO): AccountOutDTO {

        val result = validator.validate(accountIn)

        if (accountIn.id == null) {
            result.addError(error(ID, MANDATORY))
        }

        if (result.isNotOk()) {
            return AccountOutDTO(null, result)
        }

        val account = accountRepository.findById(accountIn.id!!)
            .orElseThrow { AccountNotFoundException() }

        accountMapper.updateEntity(account, accountIn)

        return AccountOutDTO(accountMapper.toDTO(accountRepository.save(account)), ValidationResult.ok())
    }
}
