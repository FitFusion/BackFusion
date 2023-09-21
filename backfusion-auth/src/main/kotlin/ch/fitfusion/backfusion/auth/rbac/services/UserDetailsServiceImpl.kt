package ch.fitfusion.backfusion.auth.rbac.services

import ch.fitfusion.backfusion.auth.rbac.repositories.AccountRepository
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val accountRepository: AccountRepository,
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {

        if (username == null) {
            throw AccessDeniedException("No username supplied")
        }

        val account = accountRepository.findByUsername(username)
            .orElseThrow { AccessDeniedException("User $username not found") }

        val grantedAuthorities = account.authorities.stream()
            .map { GrantedAuthority { it } }
            .toList()

        return User(username, account.password, grantedAuthorities)
    }
}
