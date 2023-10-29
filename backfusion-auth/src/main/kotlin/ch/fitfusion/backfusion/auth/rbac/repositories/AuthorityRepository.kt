package ch.fitfusion.backfusion.auth.rbac.repositories

import ch.fitfusion.backfusion.auth.rbac.entities.Authority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorityRepository : JpaRepository<Authority, Long> {

    fun getAuthorityByName(name: String): Authority
}
