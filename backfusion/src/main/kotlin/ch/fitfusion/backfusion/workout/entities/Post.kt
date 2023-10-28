package ch.fitfusion.backfusion.workout.entities

import ch.fitfusion.backfusion.auth.rbac.entities.Account
import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Post")
class Post : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(length = 50)
    var title: String = ""

    @Column(length = 250)
    var content: String = ""

    var recipe:

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    var account: Account? = null
}