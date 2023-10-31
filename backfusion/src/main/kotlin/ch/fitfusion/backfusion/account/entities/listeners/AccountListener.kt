package ch.fitfusion.backfusion.account.entities.listeners

import ch.fitfusion.backfusion.account.entities.Account
import ch.fitfusion.backfusion.account.repositories.AuthorityRepository
import jakarta.persistence.PrePersist
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*

@Component
class AccountListener {

    companion object {
        private lateinit var passwordEncoder: PasswordEncoder
        private lateinit var authorityRepository: AuthorityRepository
    }

    @Autowired
    fun init(
        passwordEncoder: PasswordEncoder,
        authorityRepository: AuthorityRepository,
    ) {
        Companion.passwordEncoder = passwordEncoder
        Companion.authorityRepository = authorityRepository
    }

    @PrePersist
    fun beforeSave(account: Account) {

        // Set creation date
        account.creationDate = Date()

        // Encrypt password
        account.password = passwordEncoder.encode(account.password)

        // Add default user role
        account.authorities = setOf(authorityRepository.getAuthorityByName("ROLE_USER"))
    }
}
