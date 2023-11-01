package ch.fitfusion.backfusion.post.entities

import ch.fitfusion.backfusion.account.entities.Account
import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Comment")
class Comment : BaseEntity() {

    @Column(length = 512)
    var content: String = ""

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    var post: Post? = null

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    var account: Account? = null
}
