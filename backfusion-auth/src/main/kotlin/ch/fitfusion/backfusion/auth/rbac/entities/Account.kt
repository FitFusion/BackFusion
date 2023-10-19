package ch.fitfusion.backfusion.auth.rbac.entities

import ch.fitfusion.backfusion.auth.rbac.entities.listeners.AccountListener
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "Account")
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

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "Account_Authority",
        joinColumns = [JoinColumn(name = "account_id")],
        inverseJoinColumns = [JoinColumn(name = "authority_id")]
    )
    val authorities: Set<Authority> = HashSet()
}
