package ch.fitfusion.backfusion.account.mappers

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.auth.rbac.entities.Account
import ch.fitfusion.backfusion.auth.rbac.repositories.AccountRepository
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
interface AccountMapper {

    fun toDTO(account: Account): AccountDTO

    fun toEntity(accountDTO: AccountDTO): Account

    fun toEntity(accountDTO: AccountInDTO): Account

    fun updateEntity(account: Account, accountDTO: AccountInDTO)
    fun getAccount(dto: AccountDTO): Account
}

@Component
class AccountMapperImpl(
    private val repository: AccountRepository
) : AccountMapper {

    override fun toDTO(account: Account): AccountDTO {

        return AccountDTO(
            account.username,
            account.email,
        )
    }

    override fun toEntity(accountDTO: AccountDTO): Account {

        val account = Account()

        account.email = accountDTO.email
        account.username = accountDTO.username

        return account
    }

    override fun toEntity(accountDTO: AccountInDTO): Account {

        val account = Account()

        // At this point the values should've been validated!
        account.email = accountDTO.email!!
        account.username = accountDTO.username!!
        account.password = accountDTO.password!!

        return account
    }

    override fun updateEntity(account: Account, accountDTO: AccountInDTO) {
        account.email = accountDTO.email!!
        account.username = accountDTO.username!!
        account.password = accountDTO.password!!
    }

    override fun getAccount(dto: AccountDTO): Account {
        return repository.findByUsername(dto.username)
            .orElseThrow { NullPointerException("An account has to exist when it is in the SecurityContext!") }
    }
}
