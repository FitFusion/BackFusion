package ch.fitfusion.backfusion.workout.mappers

import ch.fitfusion.backfusion.api.account.dtos.AccountDTO
import ch.fitfusion.backfusion.auth.rbac.entities.Account
import ch.fitfusion.backfusion.auth.rbac.repositories.AccountRepository
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "sptring")
interface AccountMapper {
    fun toDTO(entity: Account): AccountDTO

    fun getAccount(dto: AccountDTO): Account
}

@Component
class AccountMapperImpl(
    private val repository: AccountRepository
) : AccountMapper{

    override fun toDTO(entity: Account): AccountDTO {
        return AccountDTO(entity.username, entity.email);
    }

    override fun getAccount(dto: AccountDTO): Account {
        return repository.findByUsername(dto.username)
            .orElseThrow { NullPointerException("An account has to exist when it is in the SecurityContext!") }
    }
}
