package ch.fitfusion.backfusion.account.repositories

import ch.fitfusion.backfusion.account.entities.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : JpaRepository<Account, Long> {

    fun findByUsernameAndPassword(username: String, password: String): Optional<Account>

    fun findByUsername(username: String): Optional<Account>
}
