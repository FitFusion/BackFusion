package ch.fitfusion.backfusion.account.util

import ch.fitfusion.backfusion.account.entities.Account
import ch.fitfusion.backfusion.account.repositories.AccountRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class AccountUtil(
    private val repository: AccountRepository,
) {

    fun getAccountFromContext(): Account {

        val userDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails

        return repository.findByUsername(userDetails.username)
            .orElseThrow { NullPointerException("An account has to exist when it is in the SecurityContext!") }
    }
}
