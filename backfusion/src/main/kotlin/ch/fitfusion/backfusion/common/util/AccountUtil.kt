package ch.fitfusion.backfusion.common.util

import ch.fitfusion.backfusion.auth.rbac.entities.Account
import ch.fitfusion.backfusion.auth.rbac.repositories.AccountRepository
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class AccountUtil(
    private val repository: AccountRepository,
) {

    private fun getUserDetails(): UserDetails = SecurityContextHolder.getContext().authentication as UserDetails

    fun getAccountFromContext(): Account {
        return repository.findByUsername(getUserDetails().username)
            .orElseThrow { NullPointerException("An account has to exist when it is in the SecurityContext!") }
    }
}
