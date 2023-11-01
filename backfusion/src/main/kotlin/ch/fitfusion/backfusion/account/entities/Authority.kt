package ch.fitfusion.backfusion.account.entities

import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Authority")
class Authority : BaseEntity() {

    @Column
    var name: String = ""

    @ManyToMany(mappedBy = "authorities")
    private val accounts: Set<Account> = HashSet()
}
