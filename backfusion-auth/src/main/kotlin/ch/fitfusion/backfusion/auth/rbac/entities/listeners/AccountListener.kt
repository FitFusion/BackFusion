package ch.fitfusion.backfusion.auth.rbac.entities.listeners

import ch.fitfusion.backfusion.auth.rbac.entities.Account
import jakarta.persistence.PrePersist
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*

@Component
class AccountListener {

    companion object {
        private lateinit var encoder: PasswordEncoder
    }

    @Autowired
    fun init(passwordEncoder: PasswordEncoder) {
        encoder = passwordEncoder
    }

    @PrePersist
    fun beforeSave(account: Account) {
        // Encrypt password
        account.password = encoder.encode(account.password)

        // Set creation date
        account.creationDate = Date()
    }
}
