package ch.fitfusion.backfusion.auth.rbac.entities.listeners

import ch.fitfusion.backfusion.auth.rbac.entities.Account
import jakarta.persistence.PrePersist
import org.springframework.stereotype.Component
import java.util.*

@Component
class AccountListener {

    @PrePersist
    fun setCreationDate(account: Account) {
        account.creationDate = Date()
    }
}
