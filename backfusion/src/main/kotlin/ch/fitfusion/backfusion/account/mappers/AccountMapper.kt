package ch.fitfusion.backfusion.account.mappers

import ch.fitfusion.backfusion.account.entities.Account
import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
abstract class AccountMapper {

    abstract fun toDTO(account: Account): AccountDTO

    abstract fun toEntity(accountDTO: AccountDTO): Account

    abstract fun toEntity(accountDTO: AccountInDTO): Account

    fun updateEntity(account: Account, accountDTO: AccountInDTO) {
        account.email = accountDTO.email!!
        account.username = accountDTO.username!!
        account.password = accountDTO.password!!
    }
}
