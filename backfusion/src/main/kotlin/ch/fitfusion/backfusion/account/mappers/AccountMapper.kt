package ch.fitfusion.backfusion.account.mappers

import ch.fitfusion.backfusion.account.entities.Account
import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.api.account.dtos.AccountInDTO
import org.mapstruct.InheritConfiguration
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
abstract class AccountMapper {

    @InheritInverseConfiguration
    abstract fun toDTO(account: Account): AccountDTO

    @Mapping(target = "workouts", ignore = true)
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    abstract fun toEntity(accountDTO: AccountDTO): Account

    @InheritConfiguration
    abstract fun toEntity(accountDTO: AccountInDTO): Account

    fun updateEntity(account: Account, accountDTO: AccountInDTO) {
        account.email = accountDTO.email!!
        account.username = accountDTO.username!!
        account.password = accountDTO.password!!
    }
}
