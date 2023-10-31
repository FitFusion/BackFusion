package ch.fitfusion.backfusion.account.entities

import jakarta.persistence.*

@Entity
@Table(name = "Authority")
class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column
    var name: String = ""

    @ManyToMany(mappedBy = "authorities")
    private val accounts: Set<Account> = HashSet()
}
