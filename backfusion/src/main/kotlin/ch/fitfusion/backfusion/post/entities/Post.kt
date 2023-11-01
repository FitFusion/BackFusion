package ch.fitfusion.backfusion.post.entities

import ch.fitfusion.backfusion.account.entities.Account
import ch.fitfusion.backfusion.common.entities.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Post")
class Post : BaseEntity() {

    @Column(length = 50)
    var title: String = ""

    @Column(length = 250)
    var content: String = ""

    @Column
    var likes: Long = 0

    @Column // TODO: Image
    var image: String = ""

    @OneToOne(
        mappedBy = "post",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var recipe: Recipe? = null

    @OneToMany(
        mappedBy = "post",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var comments: List<Comment>? = null

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    var account: Account? = null
}
