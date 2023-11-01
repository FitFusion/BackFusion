package ch.fitfusion.backfusion.auth.rbac.services

import ch.fitfusion.backfusion.account.repositories.AccountRepository
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UserDetailsServiceImpl(
    private val accountRepository: AccountRepository,
) : UserDetailsService {

    @Transactional
    override fun loadUserByUsername(username: String?): UserDetails {

        if (username == null) {
            throw AccessDeniedException("No username supplied")
        }

        val account = accountRepository.findByUsername(username)
            .orElseThrow { AccessDeniedException("User $username not found") }

        val grantedAuthorities = account.authorities.stream()
            .map { GrantedAuthority { it.name } }
            .toList()

        return User(username, account.password, grantedAuthorities)
    }
}
