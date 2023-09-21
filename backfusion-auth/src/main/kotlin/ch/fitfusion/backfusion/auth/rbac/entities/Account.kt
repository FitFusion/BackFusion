package ch.fitfusion.backfusion.auth.rbac.entities

import ch.fitfusion.backfusion.auth.rbac.entities.listeners.AccountListener
import jakarta.persistence.*
import org.hibernate.internal.util.collections.CollectionHelper.listOf
import java.util.*

@Entity
@Table(name = "TBL_Account")
@EntityListeners(AccountListener::class)
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column
    var username: String = ""

    @Column
    var password: String = ""

    @Column
    var email: String = ""

    @Column
    var emailVerified: Boolean = false

    @Column
    var secondFactorEnabled: Boolean = false

    @Column
    var creationDate: Date = Date()

    @Column
    @ElementCollection(fetch = FetchType.EAGER)
    var authorities: List<String> = listOf()
}
