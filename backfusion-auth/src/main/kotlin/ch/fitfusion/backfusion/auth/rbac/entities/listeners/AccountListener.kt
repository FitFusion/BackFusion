package ch.fitfusion.backfusion.auth.rbac.entities.listeners

import ch.fitfusion.backfusion.auth.rbac.entities.Account
import jakarta.persistence.PrePersist
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*

@Component
class AccountListener {

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @PrePersist
    fun beforeSave(account: Account) {
        // Encrypt password
        account.password = passwordEncoder.encode(account.password)

        // Set creation date
        account.creationDate = Date()
    }
}
