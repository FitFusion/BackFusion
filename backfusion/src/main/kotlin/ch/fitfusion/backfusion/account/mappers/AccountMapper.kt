package ch.fitfusion.backfusion.account.mappers

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import ch.fitfusion.backfusion.auth.rbac.entities.Account
import org.springframework.stereotype.Component

//@Mapper
//interface AccountMapper {
//
//    fun toDTO(account: Account): AccountDTO
//
//    fun toEntity(accountDTO: AccountDTO): Account
//}
@Component
class AccountMapper {
    fun toDTO(account: Account): AccountDTO {

        return AccountDTO(
            account.email,
            account.username,
        )
    }

    fun toEntity(accountDTO: AccountDTO): Account {

        val account = Account()

        account.email = accountDTO.email
        account.username = accountDTO.username

        return account
    }

    fun toEntity(accountDTO: AccountInDTO): Account {

        val account = Account()

        account.email = accountDTO.email
        account.username = accountDTO.username
        account.password = accountDTO.password

        return account
    }

}
